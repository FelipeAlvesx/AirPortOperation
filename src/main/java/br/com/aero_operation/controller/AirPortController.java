package br.com.aero_operation.controller;

import br.com.aero_operation.dtos.AirPortDto;
import br.com.aero_operation.dtos.GateRequestDTO;
import br.com.aero_operation.service.AirPortService;
import br.com.aero_operation.service.GateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport")
public class AirPortController {

    @Autowired
    private AirPortService airPortService;

    @Autowired
    private GateService gateService;

    @PostMapping
    @Transactional
    public ResponseEntity<AirPortDto> createAirport(@Valid @RequestBody AirPortDto airPortDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(airPortService.createAirPort(airPortDto));
    }

    @PostMapping("{id}/gate")
    @Transactional
    public ResponseEntity<?> createGate(@Valid @PathVariable Long id, @RequestBody GateRequestDTO gateRequestDTO){
        gateService.createGate(gateRequestDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
