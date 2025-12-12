package br.com.aero_operation.model.airport;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AirPortRepository extends JpaRepository<AirPort, Long> {
    Optional<AirPort> findByCode(String s);
}
