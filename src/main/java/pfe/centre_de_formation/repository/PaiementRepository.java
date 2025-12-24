package pfe.centre_de_formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.centre_de_formation.model.Paiement;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    List<Paiement> findByFactureId(Long factureId);
}
