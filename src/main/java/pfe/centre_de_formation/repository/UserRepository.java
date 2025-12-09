package pfe.centre_de_formation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pfe.centre_de_formation.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findByToken(String token);
}
