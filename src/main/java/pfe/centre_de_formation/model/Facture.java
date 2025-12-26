package pfe.centre_de_formation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "factures")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFacture;
    private double montantHT;
    private double montantTVA;
    private double montantTTC;
    private LocalDate dateFacture = LocalDate.now();
    private boolean payee = false;

    // =========================
    // 🔗 RELATIONS JPA
    // =========================

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @Column(name = "session_id")
    private Long sessionId;

    // =========================
    // CONSTRUCTEURS
    // =========================

    public Facture() { }

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroFacture() { return numeroFacture; }
    public void setNumeroFacture(String numeroFacture) { this.numeroFacture = numeroFacture; }

    public double getMontantHT() { return montantHT; }
    public void setMontantHT(double montantHT) { this.montantHT = montantHT; }

    public double getMontantTVA() { return montantTVA; }
    public void setMontantTVA(double montantTVA) { this.montantTVA = montantTVA; }

    public double getMontantTTC() { return montantTTC; }
    public void setMontantTTC(double montantTTC) { this.montantTTC = montantTTC; }

    public LocalDate getDateFacture() { return dateFacture; }
    public void setDateFacture(LocalDate dateFacture) { this.dateFacture = dateFacture; }

    public boolean isPayee() { return payee; }
    public void setPayee(boolean payee) { this.payee = payee; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }
}
