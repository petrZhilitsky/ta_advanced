package com.epam.gomel.taf.framework.exception;

import static java.lang.String.format;

public class WrongBrowserException extends RuntimeException {
    public WrongBrowserException(String message, Object... params) {
        super(format(message, params));
    }
}
