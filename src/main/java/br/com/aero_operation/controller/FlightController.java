package br.com.aero_operation.controller;

import br.com.aero_operation.dtos.FlightDetailsDto;
import br.com.aero_operation.dtos.FlightDto;
import br.com.aero_operation.dtos.FlightGateAllocationDto;
import br.com.aero_operation.model.flight.Flight;
import br.com.aero_operation.service.FlightService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<FlightDetailsDto> addFlight(@Valid @RequestBody FlightDto flightDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.createFlight(flightDto));
    }

    @PatchMapping("/{flightId}/allocate-gate")
    @Transactional
    public ResponseEntity<FlightDetailsDto> allocateGate(@PathVariable Long flightId, @RequestBody FlightGateAllocationDto request) {

        Flight updatedFlight = flightService.allocateGateToFlight(flightId, request.gateId());
        return ResponseEntity.status(HttpStatus.OK).body(new FlightDetailsDto(updatedFlight));
    }

    @GetMapping
    public ResponseEntity<List<FlightDetailsDto>> getAllFlights() {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getAllFlights());
    }

}
