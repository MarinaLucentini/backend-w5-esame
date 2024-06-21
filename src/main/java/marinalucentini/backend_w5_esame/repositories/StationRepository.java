package marinalucentini.backend_w5_esame.repositories;

import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.enums.TypeStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {
    @Query("SELECT s FROM Station s LEFT JOIN FETCH s.reservationList WHERE s.type=:type AND s.building.city = :city")
List<Station> findByTypeAndCity(@Param("type") TypeStation typeStation,@Param("city") String city);


}
