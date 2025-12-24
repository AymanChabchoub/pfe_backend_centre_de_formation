package pfe.centre_de_formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Inscription;
import pfe.centre_de_formation.service.InscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping
    public Inscription create(@RequestBody Inscription inscription) {
        return inscriptionService.save(inscription);
    }

    @GetMapping
    public List<Inscription> getAll() {
        return inscriptionService.getAll();
    }

    @GetMapping("/{id}")
    public Inscription getById(@PathVariable Long id) {
        return inscriptionService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Inscription> getByUser(@PathVariable Long userId) {
        return inscriptionService.getByUser(userId);
    }

    @GetMapping("/session/{sessionId}")
    public List<Inscription> getBySession(@PathVariable Long sessionId) {
        return inscriptionService.getBySession(sessionId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inscriptionService.delete(id);
    }
}
