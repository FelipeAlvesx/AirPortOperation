package br.com.aero_operation.infra.exception;

public class InvalidGateAllocationException extends RuntimeException {
    public InvalidGateAllocationException(String message) {
        super(message);
    }
    
}
