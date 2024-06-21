package marinalucentini.backend_w5_esame.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import marinalucentini.backend_w5_esame.enums.TypeStation;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Station {
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private int maxCapacity;
    @Enumerated(EnumType.STRING)
    private TypeStation typeStation;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @OneToMany(mappedBy = "station")
    private List<Reservation> reservationList;

    public Station(String description, int maxCapacity, TypeStation typeStation) {
        this.description = description;
        this.maxCapacity = maxCapacity;
        this.typeStation = typeStation;

    }
}
