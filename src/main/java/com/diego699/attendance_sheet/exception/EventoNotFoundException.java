package com.diego699.attendance_sheet.exception;

public class EventoNotFoundException extends RuntimeException {
    public EventoNotFoundException(String message) {
        super(message);
    }

    public EventoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventoNotFoundException(Throwable cause) {
        super(cause);
    }
}
