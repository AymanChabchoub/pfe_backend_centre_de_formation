package pfe.centre_de_formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.centre_de_formation.model.Charge;

import java.util.List;
@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {
    List<Charge> findBySessionFormationId(Long sessionId); // toutes les charges d'une session
}
