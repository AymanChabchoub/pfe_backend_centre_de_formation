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

    private String salle;

    // 🔗 Formateur (optionnel pour le moment)
    private Long formateurId;

    // --------- Constructeurs ---------
    public SessionFormation() {}

    public SessionFormation(String titre, String description, LocalDate dateDebut,
                            LocalDate dateFin, String salle, Long formateurId) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.salle = salle;
        this.formateurId = formateurId;
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

    public String getSalle() { return salle; }
    public void setSalle(String salle) { this.salle = salle; }

    public Long getFormateurId() { return formateurId; }
    public void setFormateurId(Long formateurId) { this.formateurId = formateurId; }
}

