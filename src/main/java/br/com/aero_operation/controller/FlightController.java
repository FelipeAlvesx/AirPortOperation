package br.com.aero_operation.controller;

import br.com.aero_operation.dtos.FlightDto;
import br.com.aero_operation.dtos.GateRequestDTO;
import br.com.aero_operation.service.FlightService;
import br.com.aero_operation.service.GateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<FlightDto> addFlight(@Valid @RequestBody FlightDto flightDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.createFlight(flightDto));
    }

}
