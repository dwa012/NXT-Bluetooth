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
 * This is a class that models a GUI interface to send message to NXT device
 * through a bluetooth connection. 
 * The GUI was made with Netbeans.
 *  
 * @author Daniel Ward
 * @version 1.00
 * @date Feb 16 2011
 */

public class GUI extends javax.swing.JFrame {
    
    private java.util.ArrayList<DevicePair<String,String>> devices;
    
    /** Creates new form GUI */
    public GUI() {        
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        scanButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        messageField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        mailboxSelection = new javax.swing.JComboBox();
        mailboxLabel = new javax.swing.JLabel();
        deviceLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        deviceScrollPane = new javax.swing.JScrollPane();
        remoteDeviceList = new javax.swing.JList();
        progressBar = new javax.swing.JProgressBar();
        menubar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveDevices = new javax.swing.JMenuItem();
        loadDevices = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NXT Bluetooth Messenger");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        scanButton.setText("Scan");
        scanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanButtonActionPerformed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        messageLabel.setText("Message");
        messageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mailboxSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        mailboxLabel.setText("Mailbox");

        deviceLabel.setText("Devices");

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        remoteDeviceList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        remoteDeviceList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        deviceScrollPane.setViewportView(remoteDeviceList);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(deviceLabel))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deviceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scanButton, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(messageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mailboxLabel)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(messageField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(mailboxSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(deviceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mailboxLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mailboxSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton)
                        .addGap(11, 11, 11)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deviceScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(scanButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menubar.setBackground(new java.awt.Color(204, 204, 204));

        fileMenu.setBackground(new java.awt.Color(204, 204, 204));
        fileMenu.setText("File");

        saveDevices.setText("Save Device List");
        saveDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDevicesActionPerformed(evt);
            }
        });
        fileMenu.add(saveDevices);

        loadDevices.setText("Load Device List");
        loadDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDevicesActionPerformed(evt);
            }
        });
        fileMenu.add(loadDevices);

        menubar.add(fileMenu);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanButtonActionPerformed
         
        //set the cursor to a wait status
        this.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
        
        //create a new find object to find devices
        FindDevices find = new FindDevices();
        
        //start the find thread
        find.start();
        
        //reset the cursor to the normal one
        this.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_scanButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
       
       //get the information fomr the device list, message box, and the mailbox
       int deviceIndex = remoteDeviceList.getSelectedIndex(); 
       String message = messageField.getText();
       int mailbox = mailboxSelection.getSelectedIndex() + 1;
       
       //if no device is selcted then throw an error 
       if(deviceIndex == -1)
           javax.swing.JOptionPane.showMessageDialog(null, "No Device Selected");
               
       //if there is no message then throw an error
       else if(message.equals(""))
           javax.swing.JOptionPane.showMessageDialog(null, "The message cannot be empty");
      
       //if the message is past the maximum lenght for the device then throw an error
       else if (message.length() > 55)
           javax.swing.JOptionPane.showMessageDialog(null, "The message is too long");
          
       //if the three previous test past then create a send message thread
       else 
       {
           SendMessage send = new SendMessage();
           send.run();
       }
               
    }//GEN-LAST:event_sendButtonActionPerformed

    private void saveDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDevicesActionPerformed
        
        //create a file chooser so the user can choose a location to save
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        
        //get the result of the file chooser
        int returnVal = fileChooser.showSaveDialog(this);
        
        //if the location was approved
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION)
        {
           //get the files reference from the file chooser
           java.io.File file = fileChooser.getSelectedFile();
           
           try{
               //create the streams to write the file
               java.io.FileWriter fileWriter = new java.io.FileWriter(file);
               java.io.BufferedWriter writer = new java.io.BufferedWriter(fileWriter);
               
               /*
                * Write the information for all the devices in the list
                * Write the data to the file is the following manner:
                * Name
                * Address
                */
               for(int i = 0; i < devices.size(); i++){
                   //write the name
                   writer.write(devices.get(i).getName());
                   //use the system dependent line separator
                   writer.write(System.getProperty("line.separator"));
                   //write the address
                   writer.write(devices.get(i).getAddress());
                   //use the system dependent line separator
                   writer.write(System.getProperty("line.separator"));
               }
               
               //close the streams and the file
               writer.flush();
               writer.close();
               fileWriter.close();
           }
           catch(java.io.IOException e){}
        }//end if
    }//GEN-LAST:event_saveDevicesActionPerformed

    private void loadDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDevicesActionPerformed
        
        //create file chooser
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        
        //get the return value of the file chooser
        int returnVal = fileChooser.showOpenDialog(this);
        
        //if the selection was approved
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION)
        {
           //get the file reference from the chooser
           java.io.File file = fileChooser.getSelectedFile();
           
           try{
               //create a new scanner to read the file
               java.util.Scanner fileScanner = new java.util.Scanner(file);
               
               //create a new list of devices to hold the devices from the file
               devices = new java.util.ArrayList<DevicePair<String,String>>();
               
               //read the file till the end is reached
               while(fileScanner.hasNext())
               {
                   //read the name first
                   String name = fileScanner.nextLine();
                   //read the address second
                   String address = fileScanner.nextLine();
                   //creae a new Devicepair and add it to the device list
                   devices.add(new DevicePair<String,String>(name,address));
               }
               
               //close the scanner
               fileScanner.close();
               
               //if there were devices in the file then update the device list in the GUI
               if(!devices.isEmpty())
               {
                   //create a new String array to hold the device names
                    String[] deviceNames = new String[devices.size()];

                    //get every name form the list and add it to the array
                    for(int i = 0; i < devices.size(); i++)
                        deviceNames[i] = devices.get(i).getName();

                    //set the list data in the GUI to the data into the array
                    remoteDeviceList.setListData(deviceNames);
               }
           }//end try
           catch(java.io.IOException e){}
        }//end if        
    }//GEN-LAST:event_loadDevicesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deviceLabel;
    private javax.swing.JScrollPane deviceScrollPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem loadDevices;
    private javax.swing.JLabel mailboxLabel;
    private javax.swing.JComboBox mailboxSelection;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JTextField messageField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JList remoteDeviceList;
    private javax.swing.JMenuItem saveDevices;
    private javax.swing.JButton scanButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * This class models a thread the will find the nearby devices.
     * This is done as a thread in order not the freeze the main GUI.
     */
    private class FindDevices extends Thread{
        
        public FindDevices(){
            //left empty
        }
        
        /**
         * This the run method that is overridden from Thread.
         * This method will disable the scan button, set the cursor to
         * the wait status, and start the progress bar.
         * 
         * When the thread finishes, it will reset the cursor, stop the
         * progress bar, enable the scan button, 
         * and update the device list in the main GUI.
         * 
         * If no devices are found a alert will be raised.
         */
        @Override
        public void run(){
            
            //disable the scan button
            GUI.this.scanButton.setEnabled(false);
            
            //start the progress bar
            GUI.this.progressBar.setIndeterminate(true);
            
            try
            {
                //updat the device list to the discover devices
                GUI.this.devices = BluetoothDeviceDiscovery.discoverDevices();
            }
            catch(java.io.IOException e){}

            //if some devices were found then uodate the list in the main GUI
            //if no devices were found then throw an error
            if(devices != null)
            {
                //create a array of the device names
                String[] deviceNames = new String[devices.size()];

                //add the device names to the array
                for(int i = 0; i < devices.size(); i++)
                    deviceNames[i] = devices.get(i).getName();

                //update the list of devices in the main GUI
                GUI.this.remoteDeviceList.setListData(deviceNames);
            
            }
            else
                javax.swing.JOptionPane.showMessageDialog(null, "Could not get devices");
            
            //stop th progress bar
            GUI.this.progressBar.setIndeterminate(false);
            //enable the scan button
            GUI.this.scanButton.setEnabled(true);
            
        }//end run
    }//end class FindDevices
    
    /**
     * This class models the sending of a message to the device from the GUI
     * This is done as a thread in order to not freeze the main GUI
     */
    private class SendMessage extends Thread{
        
        public SendMessage(){
            //left blank
        }
        
        /**
         * This method is overridden from Thread.
         * 
         * This method will disable the send button, start the progress bar,
         * and try to send the message to the selected device.
         * 
         * When the thread ends it will enable the send button, stop the
         * progress bar and display a status message of the sending operation
         */
        public void run()
        {
            //disable the send button
            GUI.this.sendButton.setEnabled(false);
            //start the progress bar
            GUI.this.progressBar.setIndeterminate(true);

            //get the address of the selected device from the main GUI
            String address = GUI.this.devices.get(GUI.this.remoteDeviceList.getSelectedIndex()).getAddress();           

            //Create a new messagind object with the address of the device
            NXTMessaging messenger = new NXTMessaging(address);

            try
            {
                //get the selected mailbox
                int mailbox = GUI.this.mailboxSelection.getSelectedIndex() + 1;
                //get the enterd message
                String message = GUI.this.messageField.getText();
                //send the message to the mailbox
                messenger.send(mailbox, message);
            }
            catch(java.lang.NullPointerException e){}

            //if the sending was successful, then display status message
            if(messenger.status() == NXTMessaging.SUCCESS)       
            {
               GUI.this.statusLabel.setForeground(java.awt.Color.GREEN);
               GUI.this.statusLabel.setText("Message Sent");
            }
            //if not successful then display status message
            else
            {
               GUI.this.statusLabel.setForeground(java.awt.Color.RED);
               GUI.this.statusLabel.setText("Failed to send");
            }

            //stop the progress bar
            GUI.this.progressBar.setIndeterminate(false);
            //enable the send button
            GUI.this.sendButton.setEnabled(true);
        }//end run
    }//end class SendMessage
}//end class GUI