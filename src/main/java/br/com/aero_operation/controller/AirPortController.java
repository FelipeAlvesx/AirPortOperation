package br.com.aero_operation.controller;

import br.com.aero_operation.dtos.AirPortDto;
import br.com.aero_operation.service.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirPortController {

    @Autowired
    private AirPortService airPortService;

    @PostMapping
    public ResponseEntity<?> createAirport(@RequestBody AirPortDto airPortDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(airPortService.createAirPort(airPortDto));
    }

}
