package br.com.aero_operation.dtos;

import br.com.aero_operation.model.flight.Flight;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FlightDto(

        @NotBlank
        String flightNumber,

        @NotNull
        BigDecimal price,

        @Future
        @NotBlank
        LocalDateTime departureTime,

        @Future
        @NotBlank
        LocalDateTime arrivalTime,

        @NotNull
        Long destinationId,

        @NotNull
        Long originId
        ) {

        public FlightDto(Flight flight){
                this(
                        flight.getFlightNumber(),
                        flight.getPrice(),
                        flight.getDepartureTime(),
                        flight.getArrivalTime(),
                        flight.getDestination().getId(),
                        flight.getOrigin().getId()
                );
        }
}
