package br.com.aero_operation.dtos;

import br.com.aero_operation.model.airport.AirPort;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FlightDto(
        String flightNumber,
        BigDecimal price,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        Long destinationId,
        Long originId
        ) {
}
