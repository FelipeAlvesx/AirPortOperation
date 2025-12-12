package br.com.aero_operation.model.gate;

import br.com.aero_operation.model.airport.AirPort;
import br.com.aero_operation.model.flight.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Gate")
@Table(name = "gate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    private String terminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id")
    private AirPort airPort;

}
