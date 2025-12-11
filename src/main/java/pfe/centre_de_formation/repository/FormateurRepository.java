package pfe.centre_de_formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.centre_de_formation.model.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    Formateur findById(long id); // correct, uses 'id' not 'userId'

    // If you need to search by email (from User):
    Formateur findByEmail(String email);

}
