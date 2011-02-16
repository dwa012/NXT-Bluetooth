/*
 *  ServiceRegistrationException.java
 *
 *  $Revision$ $Date$
 *
 *  (c) Copyright 2001, 2002 Motorola, Inc.  ALL RIGHTS RESERVED.
 */

package javax.bluetooth;

import java.lang.*;
import java.io.IOException;

/**
 * The <code>ServiceRegistrationException</code> is thrown when there is a failure to add
 * a service record to the local Service Discovery Database (SDDB) or to modify
 * an existing service record in the SDDB.  The failure could be because the
 * SDDB has no room for new records or because the modification being
 * attempted to a service record violated one of the rules about
 * service record updates.  This exception will also be thrown if it
 * was not possible to obtain an RFCOMM server channel needed for a
 * <code>btspp</code> service record.
 *
 * @version 1.0 February 11, 2002
 */
public class ServiceRegistrationException extends IOException {

  /**
   * Creates a <code>ServiceRegistrationException</code> without a
   * detailed message.
   */
    public ServiceRegistrationException() {
throw new RuntimeException("Not Implemented! Used to compile Code");
    }

  /**
   * Creates a <code>ServiceRegistrationException</code> with a
   * detailed message.
   *
   * @param msg the reason for the exception
   */
    public ServiceRegistrationException(String msg) {
throw new RuntimeException("Not Implemented! Used to compile Code");
    }
}
