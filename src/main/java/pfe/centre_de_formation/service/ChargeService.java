package pfe.centre_de_formation.service;


import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Charge;
import pfe.centre_de_formation.model.SessionFormation;
import pfe.centre_de_formation.repository.ChargeRepository;
import pfe.centre_de_formation.repository.SessionFormationRepository;

import java.util.List;

@Service
public class ChargeService {

    private final ChargeRepository chargeRepository;
    private final SessionFormationRepository sessionFormationRepository;

    public ChargeService(ChargeRepository chargeRepository, SessionFormationRepository sessionFormationRepository) {
        this.chargeRepository = chargeRepository;
        this.sessionFormationRepository = sessionFormationRepository;
    }

    public Charge create(Charge charge) {
        if (charge.getSessionFormation() != null && charge.getSessionFormation().getId() != null) {
            SessionFormation session = sessionFormationRepository
                    .findById(charge.getSessionFormation().getId())
                    .orElseThrow(() -> new RuntimeException("Session non trouvée"));
            charge.setSessionFormation(session);
        }
        return chargeRepository.save(charge);
    }

    public List<Charge> getAll() {
        return chargeRepository.findAll();
    }

    public Charge getById(Long id) {
        return chargeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charge non trouvée"));
    }

    public Charge update(Long id, Charge charge) {
        Charge existing = getById(id);
        existing.setType(charge.getType());
        existing.setMontant(charge.getMontant());
        existing.setDescription(charge.getDescription());
        existing.setDateCharge(charge.getDateCharge());
        if (charge.getSessionFormation() != null && charge.getSessionFormation().getId() != null) {
            SessionFormation session = sessionFormationRepository
                    .findById(charge.getSessionFormation().getId())
                    .orElseThrow(() -> new RuntimeException("Session non trouvée"));
            existing.setSessionFormation(session);
        }
        return chargeRepository.save(existing);
    }

    public void delete(Long id) {
        chargeRepository.deleteById(id);
    }

    public List<Charge> getBySessionId(Long sessionId) {
        return chargeRepository.findBySessionFormationId(sessionId);
    }
}

