package br.com.aero_operation.model.flight;

import br.com.aero_operation.model.airport.AirPort;
import br.com.aero_operation.model.gate.Gate;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Flight")
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String flightNumber;

    private BigDecimal price;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "flight_status")
    private FlightStatus flightStatus = FlightStatus.SCHEDULED;

    @ManyToOne
    @JoinColumn(name = "destination_airport_id", nullable = false)
    private AirPort destination;

    @ManyToOne
    @JoinColumn(name = "origin_airport_id", nullable = false)
    private AirPort origin;

    @ManyToOne
    @JoinColumn(name = "gate_id")
    private Gate gate;
}
