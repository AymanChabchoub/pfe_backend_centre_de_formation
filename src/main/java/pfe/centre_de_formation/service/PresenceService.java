package pfe.centre_de_formation.service;


import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Presence;
import pfe.centre_de_formation.model.SessionFormation;
import pfe.centre_de_formation.repository.PresenceRepository;
import pfe.centre_de_formation.repository.SessionFormationRepository;

import java.util.List;

@Service
public class PresenceService {

    private final PresenceRepository presenceRepository;
    private final SessionFormationRepository sessionFormationRepository;

    public PresenceService(PresenceRepository presenceRepository,SessionFormationRepository sessionFormationRepository) {
        this.presenceRepository = presenceRepository;
        this.sessionFormationRepository=sessionFormationRepository;
    }

    public Presence create(Presence presence) {
        if(presence.getSessionFormation() != null && presence.getSessionFormation().getId() != null){
            SessionFormation session = sessionFormationRepository.findById(presence.getSessionFormation().getId()) // 🔹 use instance
                    .orElseThrow(() -> new RuntimeException("Session non trouvée"));
            presence.setSessionFormation(session);
        }
        return presenceRepository.save(presence);
    }

    public List<Presence> getAll() {
        return presenceRepository.findAll();
    }

    public Presence getById(Long id) {
        return presenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Présence non trouvée avec l'id " + id));
    }

    public Presence update(Long id, Presence presenceDetails) {
        Presence presence = getById(id);

        presence.setParticipantNom(presenceDetails.getParticipantNom());
        presence.setPresent(presenceDetails.isPresent());
        presence.setDate(presenceDetails.getDate());
        presence.setHeureArrivee(presenceDetails.getHeureArrivee());
        presence.setHeureDepart(presenceDetails.getHeureDepart());
        presence.setSessionFormation(presenceDetails.getSessionFormation());

        return presenceRepository.save(presence);
    }

    public void delete(Long id) {
        Presence presence = getById(id);
        presenceRepository.delete(presence);
    }
}

