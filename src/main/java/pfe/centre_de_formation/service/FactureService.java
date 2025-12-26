package pfe.centre_de_formation.service;


import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Client;
import pfe.centre_de_formation.model.Facture;
import pfe.centre_de_formation.model.SessionFormation;
import pfe.centre_de_formation.repository.ClientRepository;
import pfe.centre_de_formation.repository.FactureRepository;
import pfe.centre_de_formation.repository.SessionFormationRepository;

import java.util.List;
@Service
public class FactureService {

    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public Facture create(Facture facture) {
        // ✅ NOTHING TO RESOLVE MANUALLY
        // client_id and session_id are already set from JSON
        return factureRepository.save(facture);
    }

    public List<Facture> getAll() {
        return factureRepository.findAll();
    }

    public Facture getById(Long id) {
        return factureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture non trouvée"));
    }

    public Facture update(Long id, Facture facture) {
        facture.setId(id);
        return factureRepository.save(facture);
    }

    public void delete(Long id) {
        factureRepository.deleteById(id);
    }
}
