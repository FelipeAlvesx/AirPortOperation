package br.com.aero_operation.model.flight;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select f from Flight f where f.gate.id = :gateId")
    Optional<Flight> findFlightByGateId(Long gateId);
}
