package br.com.aero_operation.model.gate;

import br.com.aero_operation.model.airport.AirPort;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String terminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id", nullable = false)
    @ToString.Exclude // <--- OBRIGATÓRIO: Evita loop infinito
    @EqualsAndHashCode.Exclude
    private AirPort airport;

    public Gate(String number, String terminal, AirPort airport) {
        this.number = number;
        this.terminal = terminal;
        this.airport = airport;
    }

}
