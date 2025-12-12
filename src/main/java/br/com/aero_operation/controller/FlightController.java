package br.com.aero_operation.controller;

import br.com.aero_operation.dtos.FlightDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @PostMapping("/create")
    public ResponseEntity<?> addFlight(@RequestBody FlightDto flightDto){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
