package marinalucentini.backend_w5_esame.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }
}
