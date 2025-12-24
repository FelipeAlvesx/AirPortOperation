package br.com.aero_operation.model.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.gate.id = :gateId")
    boolean findFlightByGateId(Long gateId);
}
