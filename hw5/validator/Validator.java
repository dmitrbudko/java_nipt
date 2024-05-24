package edu.phystech.hw5.validator;

@FunctionalInterface
public interface Validator {
    void validate(Object object) throws ValidationException;
}



