package br.com.aero_operation.dtos;

import br.com.aero_operation.model.gate.Gate;
import jakarta.validation.constraints.NotBlank;

public record GateRequestDTO(

        @NotBlank
        String terminal,    // Ex: "Terminal 2"

        @NotBlank
        String gateNumber   // Ex: "B14"
) {
    public GateRequestDTO(Gate newGate) {
        this(
                newGate.getTerminal(),
                newGate.getNumber()
        );
    }
}