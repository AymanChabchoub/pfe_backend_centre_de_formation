package pfe.centre_de_formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.centre_de_formation.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Tu peux ajouter des méthodes custom si nécessaire, par ex:
    // List<Client> findByNom(String nom);
}
