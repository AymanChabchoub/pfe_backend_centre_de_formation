package pfe.centre_de_formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.centre_de_formation.model.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
