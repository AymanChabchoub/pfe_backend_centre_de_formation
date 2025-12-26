package pfe.centre_de_formation.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "paiements")
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;
    private LocalDate datePaiement;

    @Column(name = "facture_id")
    private Long factureId;

    public Paiement() {
    }

    public Paiement(Long id, double montant, LocalDate datePaiement, Long factureId) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.factureId = factureId;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Long getFactureId() {
        return factureId;
    }

    public void setFactureId(Long factureId) {
        this.factureId = factureId;
    }
}
