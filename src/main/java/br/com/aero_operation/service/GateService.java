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

    public void createGate(GateRequestDTO data) {

        // PASSO 1: Buscar o Aeroporto (A "Mãe" do relacionamento) -> criar AirPortNotFoundException
        AirPort airport = airportRepository.findById(data.airportId())
                .orElseThrow(() -> new RuntimeException("Aiport not found: "));

        // Precisamos garantir que não exista outro portão com mesmo número no mesmo terminal desse aeroporto
        boolean exists = gateRepository.existsByAirportAndTerminalAndNumber(
                airport, data.terminal(), data.gateNumber());

        if (exists) {
            throw new RuntimeException("Este portão já existe neste terminal.");
        }

        // PASSO 3: Montar o Objeto
        Gate newGate = new Gate(data.gateNumber(), data.terminal(), airport);
        // Aqui fazemos a ligação da Chave Estrangeira

        gateRepository.save(newGate);

    }
}