package br.com.aero_operation.service;

import br.com.aero_operation.dtos.FlightDetailsDto;
import br.com.aero_operation.dtos.FlightDto;
import br.com.aero_operation.infra.exception.BusinessException;
import br.com.aero_operation.infra.exception.InvalidArrivalTimeException;
import br.com.aero_operation.infra.exception.InvalidGateAllocationException;
import br.com.aero_operation.infra.exception.InvalidPriceException;
import br.com.aero_operation.model.airport.AirPortRepository;
import br.com.aero_operation.model.flight.Flight;
import br.com.aero_operation.model.flight.FlightRepository;
import br.com.aero_operation.model.gate.Gate;
import br.com.aero_operation.model.gate.GateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;  


@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirPortRepository airPortRepository;

    @Autowired
    private GateRepository gateRepository;


    public FlightDetailsDto createFlight(FlightDto flightDto){
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
        return new FlightDetailsDto(flight);
    }

    public Flight allocateGateToFlight(Long flightId, Long gateId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(
                () -> new RuntimeException("Flight not found"));
        Gate gate = gateRepository.findById(gateId).orElseThrow(
                () -> new RuntimeException("Gate not found"));

        validateNoConflict(flightId, gateId);
        validateAirportMatch(flight, gate);
        flight.setGate(gate);
        flightRepository.save(flight);

        return flight;
    }

    private void validateNoConflict(Long flightId, Long gateId) {
        Optional<Flight> conflictingFlight = flightRepository.findFlightByGateId(gateId);
        if (conflictingFlight.isPresent()) {
            throw new BusinessException("Gate is already allocated to another flight.");
        }
    }

    private void validateAirportMatch(Flight flight, Gate gate) {
        // O portão deve pertencer ao aeroporto de DESTINO
        if (!gate.getAirport().getId().equals(flight.getDestination().getId())) {
            throw new InvalidGateAllocationException(
                "O portão " + gate.getNumber() + 
                "nao pertence ao aeroporto de destino (" + 
                flight.getDestination().getCode() + ")"
            );
        }
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

    public List<FlightDetailsDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(FlightDetailsDto::new).toList();
    }

}
