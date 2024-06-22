package marinalucentini.backend_w5_esame.repositories;

import marinalucentini.backend_w5_esame.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
boolean existsByAddress(String address);
    @Query("SELECT b FROM Building b LEFT JOIN FETCH b.stationList WHERE b.id = :id")
    Optional<Building> findByIdWithStations(@Param("id") UUID id);
    Building findByName (String name);
}
