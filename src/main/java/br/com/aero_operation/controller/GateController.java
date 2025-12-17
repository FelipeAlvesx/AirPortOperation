package br.com.aero_operation.controller;

import br.com.aero_operation.dtos.GateRequestDTO;
import br.com.aero_operation.service.GateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/gate")
public class GateController {

    @Autowired
    private GateService gateService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<?> createGate(@Valid @RequestBody GateRequestDTO gateRequestDTO){
        gateService.createGate(gateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
