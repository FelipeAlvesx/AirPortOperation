package br.com.aero_operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aero_operation.dtos.PassengerDto;
import br.com.aero_operation.service.PassengerService;

@RequestMapping("/passengers")
@RestController
public class PassengerController {
    
    @Autowired
    private PassengerService passengerService;

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<?> Login() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> Register(@RequestBody PassengerDto passengerDto) {
        var passenger = passengerService.register(passengerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(passenger);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long id) {
        var passenger = passengerService.getPassengerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(passenger);
    }   

}
