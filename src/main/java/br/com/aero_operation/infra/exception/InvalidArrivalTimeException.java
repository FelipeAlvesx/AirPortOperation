package br.com.aero_operation.infra.exception;

public class InvalidArrivalTimeException extends RuntimeException {
    public InvalidArrivalTimeException(String message) {
        super(message);
    }
}
