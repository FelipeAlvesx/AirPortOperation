package br.com.aero_operation.service;

import br.com.aero_operation.dtos.GateRequestDTO;
import br.com.aero_operation.model.airport.AirPort;
import br.com.aero_operation.model.airport.AirPortRepository;
import br.com.aero_operation.model.gate.Gate;
import br.com.aero_operation.model.gate.GateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GateService {

    @Autowired
    private GateRepository gateRepository;

    @Autowired
    private AirPortRepository airportRepository;

    public void createGate(GateRequestDTO data, Long id) {
        AirPort airport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aiport not found: "));
        boolean exists = gateRepository.existsByAirportAndTerminalAndNumber(
                airport, data.terminal(), data.gateNumber());

        if (exists) {
            throw new RuntimeException("Este portão já existe neste terminal.");
        }

        Gate newGate = new Gate(data.gateNumber(), data.terminal(), airport);
        gateRepository.save(newGate);
    }
}