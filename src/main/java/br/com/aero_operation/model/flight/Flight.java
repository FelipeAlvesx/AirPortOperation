package br.com.aero_operation.model.flight;

import br.com.aero_operation.model.airport.AirPort;
import br.com.aero_operation.model.gate.Gate;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "flight_status")
    private FlightStatus flightStatus;

    @ManyToOne
    @Column(name = "air_port_destination")
    private AirPort airPortDestination;

    @ManyToOne
    @Column(name = "air_port_destination")
    private AirPort AirPortOrigin;

    @ManyToOne
    private Gate gate;
}
