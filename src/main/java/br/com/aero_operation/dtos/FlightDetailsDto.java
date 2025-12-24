package br.com.aero_operation.dtos;

import br.com.aero_operation.model.flight.Flight;

import java.time.LocalDateTime;

public record FlightDetailsDto(
        Long id,
        String flightNumber,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        Long destinationId,
        Long originId,
        String gateNumber
        ) {

        public FlightDetailsDto(Flight flight){
                this(   
                        flight.getId(),
                        flight.getFlightNumber(),
                        flight.getDepartureTime(),
                        flight.getArrivalTime(),
                        flight.getDestination().getId(),
                        flight.getOrigin().getId(),
                        flight.getGate() != null ? flight.getGate().getNumber() : null
                );
        }
}
