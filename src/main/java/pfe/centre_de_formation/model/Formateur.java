package pfe.centre_de_formation.model;

import jakarta.persistence.*;
import pfe.centre_de_formation.enumeration.RoleType;

@Entity
@Table(name = "formateurs")
public class Formateur extends User {

    private String prenom;
    private String telephone;
    private String specialite;
    private String cvPath;

    public Formateur() {
        super();
    }

    public Formateur(String nom, String prenom, String email, String password,
                     String telephone, String specialite, String cvPath) {
        super(nom, email, password, RoleType.FORMATEUR);
        this.prenom = prenom;
        this.telephone = telephone;
        this.specialite = specialite;
        this.cvPath = cvPath;
    }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public String getCvPath() { return cvPath; }
    public void setCvPath(String cvPath) { this.cvPath = cvPath; }
}
