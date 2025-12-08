package pfe.centre_de_formation.service;


import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.SessionFormation;
import pfe.centre_de_formation.repository.SessionFormationRepository;

import java.util.List;

@Service
public class SessionFormationService {

    private final SessionFormationRepository repo;

    public SessionFormationService(SessionFormationRepository repo) {
        this.repo = repo;
    }

    public SessionFormation create(SessionFormation s) {
        return repo.save(s);
    }

    public List<SessionFormation> getAll() {
        return repo.findAll();
    }

    public SessionFormation getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public SessionFormation update(Long id, SessionFormation s) {
        s.setId(id);
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

