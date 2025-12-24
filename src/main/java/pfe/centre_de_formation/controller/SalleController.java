package pfe.centre_de_formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Salle;
import pfe.centre_de_formation.service.SalleService;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
public class SalleController {

    @Autowired
    private SalleService salleService;

    @PostMapping
    public Salle create(@RequestBody Salle salle) {
        return salleService.save(salle);
    }

    @GetMapping
    public List<Salle> getAll() {
        return salleService.getAll();
    }

    @GetMapping("/{id}")
    public Salle getById(@PathVariable Long id) {
        return salleService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        salleService.delete(id);
    }
}
