package com.mowitnow.kata.exception;

import static java.lang.String.format;

public class IncorrectFileException extends Exception {
    private static final String MESSAGE = "Unable to process : %s, reason : %s";
    public IncorrectFileException (String fileName, String reason) {
        super(format(MESSAGE, fileName, reason));
    }
}
