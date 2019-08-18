package ru.javawebinar.topjava.util.exception;

//my exception
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}