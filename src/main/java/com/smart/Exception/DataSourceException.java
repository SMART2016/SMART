package com.smart.Exception;

/**
 * Created by dipanjan on 25/03/16.
 */
public class DataSourceException extends RuntimeException {

    public DataSourceException(){
        super();
    }
    public DataSourceException(String msg){
        super(msg);
    }

    public DataSourceException(String msg,Throwable t){
        super(msg,t);
    }

    public DataSourceException(Throwable t){
        super(t);
    }
}
