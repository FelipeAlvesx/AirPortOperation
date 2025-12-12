package br.com.aero_operation.model.gate;

import br.com.aero_operation.model.airport.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateRepository extends JpaRepository<Gate, Long> {
    boolean existsByAirPortAndTerminalAndNumber(AirPort airPort, String terminal, String number);
}
