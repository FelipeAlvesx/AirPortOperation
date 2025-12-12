package br.com.aero_operation.model.airport;

import br.com.aero_operation.model.gate.Gate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @Column(nullable = false, unique = true, length = 3)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "airPort", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gate> gates = new ArrayList<>();



}
