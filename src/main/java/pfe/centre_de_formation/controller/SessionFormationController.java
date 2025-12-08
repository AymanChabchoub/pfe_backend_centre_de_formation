package pfe.centre_de_formation.controller;


import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.SessionFormation;
import pfe.centre_de_formation.service.SessionFormationService;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin("*")
public class SessionFormationController {

    private final SessionFormationService service;

    public SessionFormationController(SessionFormationService service) {
        this.service = service;
    }

    @PostMapping
    public SessionFormation create(@RequestBody SessionFormation s) {
        return service.create(s);
    }

    @GetMapping
    public List<SessionFormation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SessionFormation getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public SessionFormation update(@PathVariable Long id, @RequestBody SessionFormation s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

