package br.com.aero_operation.dtos;

public record ErrorResponseDto(String message) {

    public ErrorResponseDto(Exception ex) {
        this(ex.getMessage());

    }

}