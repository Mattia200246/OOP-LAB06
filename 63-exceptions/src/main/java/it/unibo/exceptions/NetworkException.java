package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException extends IOException {
    
    public NetworkException(){
        super("Network error");
    }
    
    public NetworkException(String message){
        super("Network error while sending message: " + message);
    }

}