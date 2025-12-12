package br.com.aero_operation.model.airport;

import br.com.aero_operation.model.gate.Gate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Airport")
@Table(name = "airport")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirPort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String city;

    @OneToMany(mappedBy = "airport")
    private List<Gate> gate;

}
