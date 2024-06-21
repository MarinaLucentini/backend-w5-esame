package marinalucentini.backend_w5_esame.repositories;

import marinalucentini.backend_w5_esame.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
boolean existsByAddress(String address);
}
