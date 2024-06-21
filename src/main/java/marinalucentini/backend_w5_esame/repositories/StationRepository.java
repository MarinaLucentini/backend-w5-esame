package marinalucentini.backend_w5_esame.repositories;

import marinalucentini.backend_w5_esame.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {

}
