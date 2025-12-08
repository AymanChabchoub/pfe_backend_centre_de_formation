package pfe.centre_de_formation.controller;


import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.model.Client;
import pfe.centre_de_formation.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return service.create(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return service.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

