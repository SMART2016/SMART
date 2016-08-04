package com.smart.Exception;

/**
 * Created by dipanjan on 25/03/16.
 */
public class PropertLoadException extends RuntimeException {

    public PropertLoadException() {
        super();
    }

    public PropertLoadException(String msg) {
        super(msg);
    }

    public PropertLoadException(String msg, Throwable t) {
        super(msg, t);
    }

    public PropertLoadException(Throwable t) {
        super(t);
    }
}
