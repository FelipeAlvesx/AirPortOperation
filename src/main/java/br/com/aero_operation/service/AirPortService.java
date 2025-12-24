package br.com.aero_operation.service;

import br.com.aero_operation.dtos.AirPortDto;
import br.com.aero_operation.model.airport.AirPort;
import br.com.aero_operation.model.airport.AirPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirPortService {

    @Autowired
    private AirPortRepository airPortRepository;

    public AirPortDto createAirPort(AirPortDto airPortDto){
        AirPort newAirPort = new AirPort(airPortDto.code(), airPortDto.name(), airPortDto.city());
        airPortRepository.save(newAirPort);
        return new AirPortDto(newAirPort);
    }

    public void GateKeeper(Long id) {
        // Method implementation goes here
    }

}
