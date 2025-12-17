package br.com.aero_operation.dtos;

import br.com.aero_operation.model.flight.Flight;

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
