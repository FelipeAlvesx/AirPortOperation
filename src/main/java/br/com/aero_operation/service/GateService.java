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

    // Garante que tudo ou nada seja salvo (Rollback em caso de erro)
    public Gate createGate(GateRequestDTO data) {

        // PASSO 1: Buscar o Aeroporto (A "Mãe" do relacionamento)
        AirPort airport = airportRepository.findByCode(data.airportCode())
                .orElseThrow(() -> new RuntimeException("Aeroporto não encontrado: " + data.airportCode()));

        // PASSO 2: Validar Duplicidade (Regra de Negócio)
        // Precisamos garantir que não exista outro portão com mesmo número no mesmo terminal desse aeroporto
        boolean exists = gateRepository.existsByAirPortAndTerminalAndNumber(
                airport, data.terminal(), data.gateNumber());

        if (exists) {
            throw new RuntimeException("Este portão já existe neste terminal.");
        }

        // PASSO 3: Montar o Objeto
        Gate newGate = new Gate();
        newGate.setNumber(data.gateNumber());
        newGate.setTerminal(data.terminal());
        newGate.setAirPort(airport); // Aqui fazemos a ligação da Chave Estrangeira

        // PASSO 4: Salvar
        return gateRepository.save(newGate);
    }
}