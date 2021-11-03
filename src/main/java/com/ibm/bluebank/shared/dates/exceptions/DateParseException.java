package com.ibm.bluebank.shared.dates.exceptions;

public class DateParseException extends Exception {

    public DateParseException(String pattern) {
        super("O formado esperado para a data é " + pattern);
    }
}
