package br.com.aero_operation.controller;

import br.com.aero_operation.dtos.AirPortDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirPortController {


    @PostMapping
    public ResponseEntity<?> createAirport(@RequestBody AirPortDto airPortDto){
        return null;
    }

}
