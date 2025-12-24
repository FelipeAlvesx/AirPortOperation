package br.com.aero_operation.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PassengerDto(
    @NotBlank
    String name,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String password,
    @NotBlank
    String passportNumber) {
}
