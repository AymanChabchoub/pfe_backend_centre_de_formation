package pfe.centre_de_formation.controller;


import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Charge;
import pfe.centre_de_formation.service.ChargeService;

import java.util.List;

@RestController
@RequestMapping("/api/charges")
@CrossOrigin("*")
public class ChargeController {

    private final ChargeService chargeService;

    public ChargeController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @PostMapping
    public Charge create(@RequestBody Charge charge) {
        return chargeService.create(charge);
    }

    @GetMapping
    public List<Charge> getAll() {
        return chargeService.getAll();
    }

    @GetMapping("/{id}")
    public Charge getById(@PathVariable Long id) {
        return chargeService.getById(id);
    }

    @PutMapping("/{id}")
    public Charge update(@PathVariable Long id, @RequestBody Charge charge) {
        return chargeService.update(id, charge);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chargeService.delete(id);
    }

    @GetMapping("/session/{sessionId}")
    public List<Charge> getBySession(@PathVariable Long sessionId) {
        return chargeService.getBySessionId(sessionId);
    }
}

