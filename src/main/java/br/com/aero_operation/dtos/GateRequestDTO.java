package br.com.aero_operation.dtos;

public record GateRequestDTO(
        String airportCode, // Ex: "GRU"
        String terminal,    // Ex: "Terminal 2"
        String gateNumber   // Ex: "B14"
) {}