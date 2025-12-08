package pfe.centre_de_formation.controller;


import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Facture;
import pfe.centre_de_formation.service.FactureService;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
@CrossOrigin("*")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping
    public Facture create(@RequestBody Facture facture) {
        return factureService.create(facture);
    }

    @GetMapping
    public List<Facture> getAll() {
        return factureService.getAll();
    }

    @GetMapping("/{id}")
    public Facture getById(@PathVariable Long id) {
        return factureService.getById(id);
    }

    @PutMapping("/{id}")
    public Facture update(@PathVariable Long id, @RequestBody Facture facture) {
        return factureService.update(id, facture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        factureService.delete(id);
    }
}

