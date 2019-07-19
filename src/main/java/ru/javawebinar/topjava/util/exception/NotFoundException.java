package ru.javawebinar.topjava.util.exception;

public class NotFoundException extends RuntimeException { //if not found we throw it
    public NotFoundException(String message) {
        super(message);
    }
}