import java.io.*;
import java.util.ArrayList;
import javax.bluetooth.*;

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
 * This is a class that models the discover of bluetooth devices.
 *  
 * @author Daniel Ward
 * @version 1.00
 * @date Feb 16 2011
 */
public class BluetoothDeviceDiscovery implements DiscoveryListener{


    ///object used for waiting
    private static Object lock = new Object();

    //vector containing the devices discovered
    private static ArrayList<RemoteDevice> devices = new ArrayList<RemoteDevice>();
    private static ArrayList<DevicePair<String,String>> devicesInfo;

    //main method of the application
    public static ArrayList<DevicePair<String,String>> discoverDevices() throws IOException {

        devicesInfo = new ArrayList<DevicePair<String,String>>();
        //create an instance of this class
        BluetoothDeviceDiscovery bluetoothDeviceDiscovery=new BluetoothDeviceDiscovery();

        //display local device address and name
        LocalDevice localDevice = LocalDevice.getLocalDevice();
        System.out.println("Address: "+localDevice.getBluetoothAddress());
        System.out.println("Name: "+localDevice.getFriendlyName());

        //find devices
        DiscoveryAgent agent = localDevice.getDiscoveryAgent();

        System.out.println("Starting device inquiry...");
        agent.startInquiry(DiscoveryAgent.GIAC, bluetoothDeviceDiscovery);
        //RemoteDevice[] devs = agent.retrieveDevices( DiscoveryAgent.PREKNOWN );
        
        //System.out.println(devs.length);

        try {
            synchronized(lock){
                lock.wait();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Device Inquiry Completed. ");

        //print all devices in vecDevices
        int deviceCount=devices.size();
        //int deviceCount=devs.length;
        if(deviceCount <= 0){
            System.out.println("No Devices Found .");
        }
        else{
            //print bluetooth device addresses and names in the format [ No. address (name) ]
            System.out.println("Bluetooth Devices: ");
            for (int i = 0; i <deviceCount; i++) {
                RemoteDevice remoteDevice= devices.get(i);
                String name = remoteDevice.getFriendlyName(true);
                String address = remoteDevice.getBluetoothAddress();
                System.out.println((i+1)+". "+ address +" ("+ name +")");
                devicesInfo.add(new DevicePair<String,String>(name,address));
                
            }
        }
        
        return devicesInfo;

    }//end main

    //methods of DiscoveryListener

    /**
     * This call back method will be called for each discovered bluetooth devices.
     */
    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
         System.out.println("Device discovered: "+btDevice.getBluetoothAddress());
        //add the device to the vector
        if(!devices.contains(btDevice)){
            devices.add(btDevice);
        }
        
    }

    //no need to implement this method since services are not being discovered
    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
    }

    //no need to implement this method since services are not being discovered
    public void serviceSearchCompleted(int transID, int respCode) {
    }

    /**
     * This callback method will be called when the device discovery is
     * completed.
     */
    public void inquiryCompleted(int discType) {
        synchronized(lock){
            lock.notify();
        }

        switch (discType) {
            case DiscoveryListener.INQUIRY_COMPLETED :
                System.out.println("INQUIRY_COMPLETED");
                break;

            case DiscoveryListener.INQUIRY_TERMINATED :
                System.out.println("INQUIRY_TERMINATED");
                break;

            case DiscoveryListener.INQUIRY_ERROR :
                System.out.println("INQUIRY_ERROR");
                break;

            default :
                System.out.println("Unknown Response Code");
                break;
        }
    }//end method
}//end class