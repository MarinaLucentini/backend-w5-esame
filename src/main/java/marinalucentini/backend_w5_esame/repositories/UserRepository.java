package marinalucentini.backend_w5_esame.repositories;

import marinalucentini.backend_w5_esame.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    User findByUsername (String username);
    User findByNameAndSurname (String name, String surname);

}
