package pfe.centre_de_formation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.centre_de_formation.model.Presence;

@Repository
public interface PresenceRepository extends JpaRepository<Presence, Long> {
    // Tu peux ajouter des méthodes comme findBySessionFormationId si besoin
}
