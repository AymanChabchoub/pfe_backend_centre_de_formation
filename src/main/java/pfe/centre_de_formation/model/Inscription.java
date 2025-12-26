package pfe.centre_de_formation.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User apprenant;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionFormation sessionFormation;

    private LocalDate dateInscription = LocalDate.now();
    private boolean payee = false;

    public Inscription() {
    }

    public Inscription(Long id, User apprenant, SessionFormation sessionFormation, LocalDate dateInscription, boolean payee) {
        this.id = id;
        this.apprenant = apprenant;
        this.sessionFormation = sessionFormation;
        this.dateInscription = dateInscription;
        this.payee = payee;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getApprenant() {
        return apprenant;
    }

    public void setApprenant(User apprenant) {
        this.apprenant = apprenant;
    }

    public SessionFormation getSessionFormation() {
        return sessionFormation;
    }

    public void setSessionFormation(SessionFormation sessionFormation) {
        this.sessionFormation = sessionFormation;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean isPayee() {
        return payee;
    }

    public void setPayee(boolean payee) {
        this.payee = payee;
    }
}

