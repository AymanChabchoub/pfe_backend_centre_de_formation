package pfe.centre_de_formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Paiement;
import pfe.centre_de_formation.repository.PaiementRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    // -------- CREATE --------
    public Paiement save(Paiement paiement) {
        if (paiement.getDatePaiement() == null) {
            paiement.setDatePaiement(LocalDate.now());
        }
        return paiementRepository.save(paiement);
    }

    // -------- READ --------
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    public List<Paiement> getByFacture(Long factureId) {
        return paiementRepository.findByFactureId(factureId);
    }

    // -------- DELETE --------
    public void delete(Long id) {
        paiementRepository.deleteById(id);
    }
}
