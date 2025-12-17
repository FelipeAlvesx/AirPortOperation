package br.com.aero_operation.service;

import br.com.aero_operation.dtos.FlightDto;
import br.com.aero_operation.model.airport.AirPortRepository;
import br.com.aero_operation.model.flight.Flight;
import br.com.aero_operation.model.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirPortRepository airPortRepository;

    public FlightDto createFlight(FlightDto flightDto){

        var originAirPort = airPortRepository.findById(flightDto.originId()).orElseThrow(
                () -> new RuntimeException("Origin airport not found"));

        var destinationAirPort = airPortRepository.findById(flightDto.destinationId()).orElseThrow(
                () -> new RuntimeException("Destination airport not found"));

        Flight flight = new Flight(
                flightDto.flightNumber(),
                flightDto.price(),
                flightDto.departureTime(),
                flightDto.arrivalTime(),
                destinationAirPort,
                originAirPort
        );

        flightRepository.save(flight);

        return new FlightDto(flight);
    }

}
