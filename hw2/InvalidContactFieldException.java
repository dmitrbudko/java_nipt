package edu.phystech.hw2;

public class InvalidContactFieldException extends RuntimeException {

    private final String fieldName;

    public InvalidContactFieldException(String fieldName) {
        super("Invalid field: " + fieldName);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}