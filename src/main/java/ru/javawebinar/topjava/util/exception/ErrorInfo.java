package ru.javawebinar.topjava.util.exception;

public class ErrorInfo {
    private final String url;
    //Represents a class or interface type that cannot be properly modeled.
    // This may be the result of a processing error, such as a missing class file or erroneous source code.
    private final ErrorType type;
    private final String detail;

    public ErrorInfo(CharSequence url, ErrorType type, String detail) {
        this.url = url.toString();
        this.type = type;
        this.detail = detail;
    }
}