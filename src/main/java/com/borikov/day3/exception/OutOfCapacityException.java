package com.borikov.day3.exception;

public class OutOfCapacityException extends Exception{
    public OutOfCapacityException() {
    }

    public OutOfCapacityException(String message) {
        super(message);
    }

    public OutOfCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfCapacityException(Throwable cause) {
        super(cause);
    }
}
