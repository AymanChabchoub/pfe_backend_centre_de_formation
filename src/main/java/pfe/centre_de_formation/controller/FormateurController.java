package pfe.centre_de_formation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Formateur;
import pfe.centre_de_formation.service.FormateurService;

import java.util.List;

@RestController
@RequestMapping("/api/formateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class FormateurController {

    @Autowired
    private FormateurService service;

    @PostMapping
    public Formateur create(@RequestBody Formateur formateur) {
        return service.save(formateur);
    }

    @GetMapping
    public List<Formateur> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Formateur getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Formateur update(@PathVariable Long id, @RequestBody Formateur formateur) {
        return service.update(id, formateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

