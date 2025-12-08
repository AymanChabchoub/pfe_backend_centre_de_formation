package pfe.centre_de_formation.model;


import jakarta.persistence.*;

@Entity
@Table(name = "formations")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private int dureeHeures; // par exemple : 40h

    private double prix; // prix de la formation

    public Formation() {}

    public Formation(Long id, String titre, String description, int dureeHeures, double prix) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dureeHeures = dureeHeures;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDureeHeures() {
        return dureeHeures;
    }

    public void setDureeHeures(int dureeHeures) {
        this.dureeHeures = dureeHeures;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
