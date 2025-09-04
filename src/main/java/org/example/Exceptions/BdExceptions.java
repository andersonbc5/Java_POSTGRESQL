package org.example.Exceptions;

public class BdExceptions extends RuntimeException{

    public BdExceptions(String msg){
        super(msg);
    }

    public BdExceptions(String msg, Throwable cause){
        super(msg,cause);
    }
}
