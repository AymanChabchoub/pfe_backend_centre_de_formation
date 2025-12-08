package pfe.centre_de_formation.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "charges")
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // ex: "Salle", "Formateur", "Logistique"
    private double montant;

    private String description;

    private LocalDate dateCharge = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionFormation sessionFormation;

    // -------- Constructeurs --------
    public Charge() {}

    public Charge(String type, double montant, String description, SessionFormation sessionFormation) {
        this.type = type;
        this.montant = montant;
        this.description = description;
        this.sessionFormation = sessionFormation;
    }

    // -------- Getters & Setters --------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDateCharge() { return dateCharge; }
    public void setDateCharge(LocalDate dateCharge) { this.dateCharge = dateCharge; }

    public SessionFormation getSessionFormation() { return sessionFormation; }
    public void setSessionFormation(SessionFormation sessionFormation) { this.sessionFormation = sessionFormation; }
}

