package pfe.centre_de_formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Inscription;
import pfe.centre_de_formation.repository.InscriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    // -------- CREATE --------
    public Inscription save(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    // -------- READ --------
    public List<Inscription> getAll() {
        return inscriptionRepository.findAll();
    }

    public Inscription getById(Long id) {
        Optional<Inscription> inscription = inscriptionRepository.findById(id);
        return inscription.orElse(null);
    }

    public List<Inscription> getByUser(Long userId) {
        return inscriptionRepository.findByApprenantId(userId);
    }

    public List<Inscription> getBySession(Long sessionId) {
        return inscriptionRepository.findBySessionFormationId(sessionId);
    }

    // -------- DELETE --------
    public void delete(Long id) {
        inscriptionRepository.deleteById(id);
    }
}
