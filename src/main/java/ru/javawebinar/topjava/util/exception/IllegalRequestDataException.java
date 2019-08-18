package ru.javawebinar.topjava.util.exception;

//my exception
public class IllegalRequestDataException extends RuntimeException {
    public IllegalRequestDataException(String msg) {
        super(msg);
    }
}