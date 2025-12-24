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

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

    public Paiement() {
    }

    public Paiement(Long id, double montant, LocalDate datePaiement, Facture facture) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.facture = facture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}

