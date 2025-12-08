package pfe.centre_de_formation.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "presences")
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String participantNom; // nom de l'apprenant ou du formateur
    private boolean present = false;

    private LocalDate date = LocalDate.now();
    private LocalTime heureArrivee;
    private LocalTime heureDepart;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionFormation sessionFormation;

    // --------- Constructeurs ---------
    public Presence() {}

    public Presence(String participantNom, boolean present, LocalDate date,
                    LocalTime heureArrivee, LocalTime heureDepart, SessionFormation sessionFormation) {
        this.participantNom = participantNom;
        this.present = present;
        this.date = date;
        this.heureArrivee = heureArrivee;
        this.heureDepart = heureDepart;
        this.sessionFormation = sessionFormation;
    }

    // --------- Getters & Setters ---------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getParticipantNom() { return participantNom; }
    public void setParticipantNom(String participantNom) { this.participantNom = participantNom; }

    public boolean isPresent() { return present; }
    public void setPresent(boolean present) { this.present = present; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeureArrivee() { return heureArrivee; }
    public void setHeureArrivee(LocalTime heureArrivee) { this.heureArrivee = heureArrivee; }

    public LocalTime getHeureDepart() { return heureDepart; }
    public void setHeureDepart(LocalTime heureDepart) { this.heureDepart = heureDepart; }

    public SessionFormation getSessionFormation() { return sessionFormation; }
    public void setSessionFormation(SessionFormation sessionFormation) { this.sessionFormation = sessionFormation; }
}

