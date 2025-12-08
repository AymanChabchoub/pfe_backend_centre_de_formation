package pfe.centre_de_formation.controller;


import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Presence;
import pfe.centre_de_formation.service.PresenceService;

import java.util.List;

@RestController
@RequestMapping("/api/presences")
@CrossOrigin("*")
public class PresenceController {

    private final PresenceService presenceService;

    public PresenceController(PresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @PostMapping
    public Presence create(@RequestBody Presence presence) {
        return presenceService.create(presence);
    }

    @GetMapping
    public List<Presence> getAll() {
        return presenceService.getAll();
    }

    @GetMapping("/{id}")
    public Presence getById(@PathVariable Long id) {
        return presenceService.getById(id);
    }

    @PutMapping("/{id}")
    public Presence update(@PathVariable Long id, @RequestBody Presence presence) {
        return presenceService.update(id, presence);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        presenceService.delete(id);
    }
}
