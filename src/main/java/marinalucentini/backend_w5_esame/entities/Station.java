package marinalucentini.backend_w5_esame.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import marinalucentini.backend_w5_esame.enums.TypeStation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Station {
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private int maxCapacity;
    @Enumerated(EnumType.STRING)
    private TypeStation type;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @OneToMany(mappedBy = "station")
    private List<Reservation> reservationList = new ArrayList<>();

    public Station(String description, int maxCapacity, TypeStation typeStation) {
        this.description = description;
        this.maxCapacity = maxCapacity;
        this.type = typeStation;

    }

    @Override
    public String toString() {
        return "Station{" +
                "building=" + building +
                ", typeStation=" + type +
                ", maxCapacity=" + maxCapacity +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
