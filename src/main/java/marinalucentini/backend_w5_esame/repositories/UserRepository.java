package marinalucentini.backend_w5_esame.repositories;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    User findByUsername (String username);
    User findByNameAndSurname (String name, String surname);
    boolean existsByUsername(String username);
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.reservationList WHERE u.id = :id")
    Optional<User> findByIdWithReservation(@Param("id") UUID id);

}
