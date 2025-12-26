package pfe.centre_de_formation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.centre_de_formation.model.Formation;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByFormateurId(Long formateurId);

}

