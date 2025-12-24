package br.com.aero_operation.dtos;

import br.com.aero_operation.model.passenger.Passenger;

public record PassengerReponseDto(
        Long id,
        String name,
        String email,
        String passportNumber
) {

    public PassengerReponseDto(Passenger passenger) {
        this(
                passenger.getId(),
                passenger.getName(),
                passenger.getEmail(),
                passenger.getPassportNumber()
        );
    }
}