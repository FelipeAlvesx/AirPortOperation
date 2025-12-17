package br.com.aero_operation.dtos;

import br.com.aero_operation.model.gate.Gate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GateRequestDTO(

        @NotNull
        Long airportId, // Ex: "GRU"

        @NotBlank
        String terminal,    // Ex: "Terminal 2"

        @NotBlank
        String gateNumber   // Ex: "B14"
) {
    public GateRequestDTO(Gate newGate) {
        this(
                newGate.getAirport().getId(),
                newGate.getTerminal(),
                newGate.getNumber()
        );
    }
}