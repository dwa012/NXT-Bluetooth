import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.*;

/**
 * The MIT License
 *
 * Copyright (c) 2011 Daniel Ward dwa012(at)gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * No person, persons, or entity is allowed to sell or make any profit off this
 * software or variants of this software.
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * 
 * This is a class to model a messaging object that communicates with a specific
 * NXT device.
 *  
 * @author Daniel Ward
 * @version 1.00
 * @date Feb 16 2011
 */

public class NXTMessaging {
    
    //constants
    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;
    
    private String address; //the MAC address of the NXT device
    private int status; //the status of the send method
    
    /**
     * Will create a object to send a message to the NXT device with the given
     * bluetooth MAC address of that device.
     * @param address The MAC address of the NXT device
     */
    public NXTMessaging(String address)
    {
        this.address = address;
    }
    
    /**
     * This method will attempt to send a message to the NXT device using the
     * given mailbox number.
     * 
     * @param mailbox The mailbox on the device to send the message to
     * @param message The message to send to the device
     */
    public void send(int mailbox, String message)
    {
        //The connection and stream objects needed for the communication
        StreamConnection connection = null;        
        DataOutputStream outstream = null;
        DataInputStream instream = null;
        
        this.status = NXTMessaging.SUCCESS;
        
        try {
            //the url of the device for the serial port communictation
            String url = "btspp://" + address + 
                         ":1;authenticate=false;encrypt=false";
            
            //open a connection to the device
            connection = (StreamConnection)Connector.open(url);
            //a output stream to send data
            outstream = connection.openDataOutputStream();
            //a inputstream to recieve a reply
            instream = connection.openDataInputStream();
        }
        catch(java.io.IOException e){
            this.status = NXTMessaging.FAILURE;
        }
        
        //stop is the conncetion was not created
        assert connection != null && outstream != null && instream != null;      
        
        ////////////////////////////////////////////////////////////////////
        //---------------------SEND THE MESSAGE---------------------------//
           
        message = message.concat("\0"); //must be null terminated
       
        //convert the message to byte array
        byte[] outMessage = message.getBytes(); 

        //The message length is the string plus 4 bytes
        int messageLength = outMessage.length + 4;

        //the actual byte array to hold the whole message
        byte[] toSend = new byte[messageLength];

        //the required header for a bluetooth message
        byte[] header = {0x00, 0x00};

        //set the value of the first byte to the size of the toSend byte array
        header[0] = (new Integer(messageLength)).byteValue();

        toSend[0] = 0x00; //Command with reply
        toSend[1] = 0x09; //Command for a messageWrite operation
        toSend[2] = (byte)(mailbox-1); //The mailbox with adjustment of -1      
        toSend[3] = (byte)(outMessage.length); // the lenght of the given message

        //move the messsage into the toSend array
        for(int i = 0; i < outMessage.length; i++)
            toSend[i+4] = outMessage[i];
           
        try {
            //write the headet to the stream
            outstream.write(header, 0 , header.length);
            //write the rest of the message to the stream
            outstream.write(toSend, 0 , toSend.length);
            //flsuh the stream to send the message
            outstream.flush();
            
        } catch (IOException ex) {
            this.status = NXTMessaging.FAILURE;
        }
        
        assert this.status != NXTMessaging.FAILURE;
        
        ////////////////////////////////////////////////////////////////////
        //-----------------------GET THE REPLY----------------------------//
        
        /*
         * Reply for message write commnd
         * byte 0 : bluetooth header, length of message
         * byte 1 : bluetooth header, 0x00
         * byte 2 : 0x02
         * byte 3 : 0x09
         * byte 4 : status message form device
         */
        
        //byte arrayt to recieve the reply
        byte[] reply = new byte[5];
        
        try {
            instream.read(reply, 0, reply.length);
        } 
        catch (IOException ex) {
            this.status = NXTMessaging.FAILURE;  
        }
        
        if(reply[4] != 0x00)
           this.status = NXTMessaging.FAILURE;
        
        try{
            //close the connection
            outstream.close();
            instream.close();
            connection.close();
        }
        catch(java.io.IOException e)
        {
            this.status = NXTMessaging.FAILURE;  
        }
        
    }
    
    /**
     * This method return the status of the send command.
     * 
     * @return  Will return NXTMessaging.SUCCESS if the send was successful,
     *          or will return NXTMessaging.FAILURE if it was not successful.
     */
    public int status()
    {
        return this.status;
    }
}
