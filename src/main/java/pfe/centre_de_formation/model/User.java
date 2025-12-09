package pfe.centre_de_formation.model;

import jakarta.persistence.*;
import pfe.centre_de_formation.enumeration.RoleType;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private LocalDateTime tokenExpiration;

    public User() {}

    public User(String nom, String prenom, String email, String password, String telephone, RoleType role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.role = role;
    }

    public User(String nom, String email, String password, RoleType roleType) {
        this.nom=nom;
        this.email=email;
        this.password=password;
        this.role=roleType;
    }

    // --------- GETTERS & SETTERS ---------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public RoleType getRole() { return role; }
    public void setRole(RoleType role) { this.role = role; }

    public LocalDateTime getTokenExpiration() { return tokenExpiration; }
    public void setTokenExpiration(LocalDateTime tokenExpiration) { this.tokenExpiration = tokenExpiration; }
}
