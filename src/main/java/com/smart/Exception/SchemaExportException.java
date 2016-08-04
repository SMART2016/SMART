package com.smart.Exception;

/**
 * Created by dipanjan on 25/03/16.
 */
public class SchemaExportException extends RuntimeException {

    public SchemaExportException(){
        super();
    }
    public SchemaExportException(String msg){
        super(msg);
    }

    public SchemaExportException(String msg, Throwable t){
        super(msg,t);
    }

    public SchemaExportException(Throwable t){
        super(t);
    }
}
