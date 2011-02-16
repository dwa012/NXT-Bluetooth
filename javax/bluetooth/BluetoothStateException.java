/*
 *  BluetoothStateException.java
 *
 *  $Revision$ $Date$ 
 * 
 *  (c) Copyright 2001, 2002 Motorola, Inc.  ALL RIGHTS RESERVED.
 */
package javax.bluetooth;

import java.lang.*;
import java.io.*;
/**
 * The <code>BluetoothStateException</code> is thrown when
 * a request is made to the Bluetooth system that
 * the system cannot support in its present state.  If, however, the
 * Bluetooth system was not in this state, it could support this operation.
 * For example, some Bluetooth systems do not allow the device to go into
 * inquiry mode if a connection is established.  This exception would be
 * thrown if <code>startInquiry()</code> were called.
 *
 * @version 1.0 February 11, 2002
 */
public class BluetoothStateException extends IOException {

    /**
     * Creates a new <code>BluetoothStateException</code> without a detail
     * message.
     */
    public BluetoothStateException() {
throw new RuntimeException("Not Implemented! Used to compile Code");
    }

    /**
     * Creates a <code>BluetoothStateException</code> with the specified
     * detail message.
     *
     * @param msg the reason for the exception
     */
    public BluetoothStateException(String msg) {
throw new RuntimeException("Not Implemented! Used to compile Code");
    }
}
