package br.com.aero_operation.service;

import br.com.aero_operation.dtos.FlightDto;
import br.com.aero_operation.infra.exception.BusinessException;
import br.com.aero_operation.infra.exception.InvalidArrivalTimeException;
import br.com.aero_operation.infra.exception.InvalidPriceException;
import br.com.aero_operation.model.airport.AirPortRepository;
import br.com.aero_operation.model.flight.Flight;
import br.com.aero_operation.model.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;


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

        validatePrice(flightDto.price());
        validateFlightTimes(flightDto.departureTime(), flightDto.arrivalTime());

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

    private void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPriceException("Price must be a positive value.");
        }
    }

    private void validateFlightTimes(LocalDateTime departure, LocalDateTime arrival) {
        LocalDateTime now = LocalDateTime.now();

        // A chegada deve ser depois da partida
        if (arrival.isBefore(departure) || arrival.isEqual(departure)) {
            throw new InvalidArrivalTimeException("arrival time must be after departure time");
        }

        // O voo deve ter duração mínima de 30 minutos
        Duration flightDuration = Duration.between(departure, arrival);
        if (flightDuration.toMinutes() < 30) {
            throw new BusinessException("the min duration for a flight is 30 minutes");
        }
    }
}
