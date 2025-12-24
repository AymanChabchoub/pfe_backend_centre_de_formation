package pfe.centre_de_formation.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sessions_formation")
public class SessionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    // 🔗 Salle
    @Column(name = "salle_id")
    private Long salleId;

    // 🔗 Formateur
    @Column(name = "formateur_id")
    private Long formateurId;

    // 🔗 Formation
    @Column(name = "formation_id")
    private Long formationId;

    // --------- Constructeurs ---------
    public SessionFormation() {}

    public SessionFormation(String titre, String description,
                            LocalDate dateDebut, LocalDate dateFin,
                            Long salleId, Long formateurId, Long formationId) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.salleId = salleId;
        this.formateurId = formateurId;
        this.formationId = formationId;
    }

    // --------- Getters & Setters ---------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public Long getSalleId() { return salleId; }
    public void setSalleId(Long salleId) { this.salleId = salleId; }

    public Long getFormateurId() { return formateurId; }
    public void setFormateurId(Long formateurId) { this.formateurId = formateurId; }

    public Long getFormationId() { return formationId; }
    public void setFormationId(Long formationId) { this.formationId = formationId; }
}
