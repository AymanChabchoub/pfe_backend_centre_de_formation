package pfe.centre_de_formation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Formateur;
import pfe.centre_de_formation.repository.FormateurRepository;

import java.util.List;

@Service
public class FormateurService {

    @Autowired
    private FormateurRepository formateurRepository;

    public Formateur save(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    public List<Formateur> getAll() {
        return formateurRepository.findAll();
    }

    public Formateur getById(Long id) {
        return formateurRepository.findById(id).orElse(null);
    }

    public Formateur update(Long id, Formateur updated) {
        Formateur f = formateurRepository.findById(id).orElse(null);
        if (f != null) {
            f.setNom(updated.getNom());
            f.setPrenom(updated.getPrenom());
            f.setEmail(updated.getEmail());
            f.setTelephone(updated.getTelephone());
            f.setSpecialite(updated.getSpecialite());
            return formateurRepository.save(f);
        }
        return null;
    }

    public void delete(Long id) {
        formateurRepository.deleteById(id);
    }
}

