package edu.phystech.hw5.validator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidatorImpl implements Validator {

    private static final String LOG_FILE_PATH = "validation_logs.txt";

    @Override
    public void validate(Object object) throws ValidationException {
        List<String> logMessages = new ArrayList<>();

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.getType() == String.class) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof NotBlank) {
                        try {
                            field.setAccessible(true);
                            String value = (String) field.get(object);
                            if (value == null || value.trim().isEmpty()) {
                                String message = "Field '" + field.getName() + "' must not be blank";
                                logMessages.add(message);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } else if (annotation instanceof Size) {
                        try {
                            field.setAccessible(true);
                            String value = (String) field.get(object);
                            Size sizeAnnotation = (Size) annotation;
                            int min = sizeAnnotation.min();
                            int max = sizeAnnotation.max();
                            if (value == null || value.length() < min || value.length() > max) {
                                String message = "Field '" + field.getName() + "' must be between " + min + " and " + max + " characters long";
                                logMessages.add(message);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        if (!logMessages.isEmpty()) {
            writeToLogFile(logMessages);
            throw new ValidationException("Validation failed. Check logs for details.");
        }
    }

    private void writeToLogFile(List<String> messages) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH))) {
            for (String message : messages) {
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
