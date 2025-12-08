package pfe.centre_de_formation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pfe.centre_de_formation.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
