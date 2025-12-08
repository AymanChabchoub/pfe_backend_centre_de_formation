package pfe.centre_de_formation.service;


import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Client;
import pfe.centre_de_formation.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    // Créer un client
    public Client create(Client client) {
        return repository.save(client);
    }

    // Récupérer tous les clients
    public List<Client> getAll() {
        return repository.findAll();
    }

    // Récupérer un client par id
    public Client getById(Long id) {
        Optional<Client> client = repository.findById(id);
        return client.orElse(null); // ou lever une exception si tu préfères
    }

    // Mettre à jour un client
    public Client update(Long id, Client clientDetails) {
        Client client = getById(id);
        if (client != null) {
            client.setNom(clientDetails.getNom());
            client.setEmail(clientDetails.getEmail());
            client.setTelephone(clientDetails.getTelephone());
            client.setAdresse(clientDetails.getAdresse());
            return repository.save(client);
        }
        return null;
    }

    // Supprimer un client
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

