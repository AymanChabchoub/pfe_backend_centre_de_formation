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
    private final SessionFormationRepository sessionFormationRepository;
    private final ClientRepository clientRepository;

    public FactureService(FactureRepository factureRepository,SessionFormationRepository sessionFormationRepository,ClientRepository clientRepository) {
        this.factureRepository = factureRepository;
        this.sessionFormationRepository=sessionFormationRepository;
        this.clientRepository=clientRepository;
    }

    public Facture create(Facture facture) {
        if(facture.getSessionFormation() != null && facture.getSessionFormation().getId() != null){
            SessionFormation session = sessionFormationRepository.findById(facture.getSessionFormation().getId()) // 🔹 use instance
                    .orElseThrow(() -> new RuntimeException("Session non trouvée"));
            facture.setSessionFormation(session);
        }
        if(facture.getClient() != null && facture.getClient().getId() != null){
            Client client = clientRepository.findById(facture.getClient().getId()) // 🔹 use instance
                    .orElseThrow(() -> new RuntimeException("Client non trouvée"));
            facture.setClient(client);
        }
        return factureRepository.save(facture);
    }

    public List<Facture> getAll() {
        return factureRepository.findAll();
    }

    public Facture getById(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    public Facture update(Long id, Facture facture) {
        facture.setId(id);
        return factureRepository.save(facture);
    }

    public void delete(Long id) {
        factureRepository.deleteById(id);
    }
}

