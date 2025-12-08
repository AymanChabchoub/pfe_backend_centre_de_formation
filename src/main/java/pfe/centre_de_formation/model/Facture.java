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

    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionFormation sessionFormation;

    // ⚡ On ajoute JsonBackReference pour éviter la boucle infinie
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public Facture() { }

    public Facture(String numeroFacture, double montantHT, double montantTVA,
                   double montantTTC, Client client, SessionFormation sessionFormation) {
        this.numeroFacture = numeroFacture;
        this.montantHT = montantHT;
        this.montantTVA = montantTVA;
        this.montantTTC = montantTTC;
        this.client = client;
        this.sessionFormation = sessionFormation;
    }

    // Getters & Setters
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

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public SessionFormation getSessionFormation() { return sessionFormation; }
    public void setSessionFormation(SessionFormation sessionFormation) { this.sessionFormation = sessionFormation; }
}
