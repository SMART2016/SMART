package com.smart.Exception;

/**
 * Created by dipanjan on 25/03/16.
 */
public class JsonConvertionException extends RuntimeException {

    public JsonConvertionException(){
        super();
    }
    public JsonConvertionException(String msg){
        super(msg);
    }

    public JsonConvertionException(String msg, Throwable t){
        super(msg,t);
    }

    public JsonConvertionException(Throwable t){
        super(t);
    }
}
