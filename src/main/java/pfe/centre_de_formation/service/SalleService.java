package pfe.centre_de_formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Salle;
import pfe.centre_de_formation.repository.SalleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    // -------- CREATE --------
    public Salle save(Salle salle) {
        return salleRepository.save(salle);
    }

    // -------- READ --------
    public List<Salle> getAll() {
        return salleRepository.findAll();
    }

    public Salle getById(Long id) {
        Optional<Salle> salle = salleRepository.findById(id);
        return salle.orElse(null);
    }

    // -------- DELETE --------
    public void delete(Long id) {
        salleRepository.deleteById(id);
    }
}
