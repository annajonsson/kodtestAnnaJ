package com.kodtestannaj.kodtestapi.exceptionhandler;

public class CsvReadException extends RuntimeException {
    public CsvReadException(String message) {
        super(message);
    }
}
