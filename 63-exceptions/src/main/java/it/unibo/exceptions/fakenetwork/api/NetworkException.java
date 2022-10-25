package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;


/**
 * This class represents a network exception.
 */


public class NetworkException extends IOException {
    /*
     * This class should extend IOException.
     */
    public NetworkException() {
        super("Network error");
    }

    /*
     * This class should extend IOException.
     */
    public NetworkException(final String message) {
        super("Network error while sending message: " + message);
    }
    
    

}
