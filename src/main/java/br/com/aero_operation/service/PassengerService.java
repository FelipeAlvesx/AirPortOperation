package br.com.aero_operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aero_operation.dtos.PassengerDto;
import br.com.aero_operation.dtos.PassengerReponseDto;
import br.com.aero_operation.model.passenger.Passenger;
import br.com.aero_operation.model.passenger.PassengerRepository;

@Service
public class PassengerService {
    
    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger register(PassengerDto passengerDto) {
        Passenger passenger = new Passenger(
                passengerDto.name(),
                passengerDto.email(),
                passengerDto.password(),
                passengerDto.passportNumber()
        );
        passengerRepository.save(passenger);
        return passenger;  
    }

    public PassengerReponseDto getPassengerById(Long id) {
        var passenger = passengerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Passenger not found"));
        return new PassengerReponseDto(passenger);
        }
    }

