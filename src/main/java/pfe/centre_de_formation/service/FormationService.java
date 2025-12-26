package pfe.centre_de_formation.service;


import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Formation;
import pfe.centre_de_formation.repository.FormationRepository;

import java.util.List;

@Service
public class FormationService {

    private final FormationRepository formationRepository;

    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public Formation ajouter(Formation formation) {
        return formationRepository.save(formation);
    }

    public List<Formation> getAll() {
        return formationRepository.findAll();
    }

    public Formation getById(Long id) {
        return formationRepository.findById(id).orElse(null);
    }

    public Formation update(Long id, Formation formation) {
        Formation existante = formationRepository.findById(id).orElse(null);
        if (existante == null) return null;

        existante.setTitre(formation.getTitre());
        existante.setDescription(formation.getDescription());
        existante.setDureeHeures(formation.getDureeHeures());
        existante.setPrix(formation.getPrix());

        return formationRepository.save(existante);
    }

    public void delete(Long id) {
        formationRepository.deleteById(id);
    }

    public List<Formation> getByFormateurId(Long formateurId) {
        return formationRepository.findByFormateurId(formateurId);
    }
}

