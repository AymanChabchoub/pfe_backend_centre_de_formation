package pfe.centre_de_formation.controller;


import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Formation;
import pfe.centre_de_formation.service.FormationService;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
@CrossOrigin("*")
public class FormationController {

    private final FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @PostMapping
    public Formation ajouter(@RequestBody Formation formation) {
        return formationService.ajouter(formation);
    }

    @GetMapping
    public List<Formation> getAll() {
        return formationService.getAll();
    }

    @GetMapping("/{id}")
    public Formation getById(@PathVariable Long id) {
        return formationService.getById(id);
    }

    @PutMapping("/{id}")
    public Formation update(@PathVariable Long id, @RequestBody Formation formation) {
        return formationService.update(id, formation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        formationService.delete(id);
    }

    @GetMapping("/formateur/{formateurId}")
    public List<Formation> getFormationByFormateurId(@PathVariable Long formateurId) {
        return formationService.getByFormateurId(formateurId);
    }
}

