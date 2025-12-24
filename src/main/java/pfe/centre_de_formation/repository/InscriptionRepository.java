package pfe.centre_de_formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.centre_de_formation.model.Inscription;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    List<Inscription> findByApprenantId(Long userId);

    List<Inscription> findBySessionFormationId(Long sessionId);
}
