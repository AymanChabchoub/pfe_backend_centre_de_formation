package pfe.centre_de_formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.centre_de_formation.model.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long> {
}
