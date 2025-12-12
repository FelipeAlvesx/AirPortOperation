package br.com.aero_operation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class firstController {

    @GetMapping
    public ResponseEntity<?> helloWorld(){
        return ResponseEntity.ok("Running!");
    }

}
