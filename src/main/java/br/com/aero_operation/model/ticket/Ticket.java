package br.com.aero_operation.model.ticket;

import br.com.aero_operation.model.flight.Flight;
import br.com.aero_operation.model.passenger.Passenger;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Ticket")
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    public void doCheckIn(String seat) {
        this.ticketStatus = TicketStatus.CHECKED_IN;
        this.seatNumber = seat;
    }

}
