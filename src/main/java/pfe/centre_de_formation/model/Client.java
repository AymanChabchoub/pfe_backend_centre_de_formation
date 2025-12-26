package pfe.centre_de_formation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import pfe.centre_de_formation.enumeration.RoleType;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends User {

    private String telephone;
    private String adresse;



    public Client() {
        super();
    }

    public Client(String nom, String email, String password,
                  String telephone, String adresse) {
        super(nom, email, password, RoleType.CLIENT);
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

}
