package marinalucentini.backend_w5_esame.repositories;

import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.enums.TypeStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {
List<Station> findByType(TypeStation typeStation);
//List<Station> findByCity(String string);
}
