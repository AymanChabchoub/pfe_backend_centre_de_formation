package pfe.centre_de_formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Paiement;
import pfe.centre_de_formation.service.PaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @PostMapping
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.getAll();
    }

    @GetMapping("/facture/{factureId}")
    public List<Paiement> getByFacture(@PathVariable Long factureId) {
        return paiementService.getByFacture(factureId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paiementService.delete(id);
    }
}
