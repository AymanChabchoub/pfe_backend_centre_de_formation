package pfe.centre_de_formation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.centre_de_formation.model.Client;
import pfe.centre_de_formation.model.User;
import pfe.centre_de_formation.repository.UserRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Durée d'expiration du token en heures (modifiable)
    private final long TOKEN_VALID_HOURS = 24;

    // ---------------- Get all users ----------------
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }


        User saved = userRepository.save(user);
        // pas de token à la création
        return saved;
    }

    /**
     * Authentifie l'utilisateur et génère un token (UUID).
     * Retourne l'utilisateur mis à jour (avec token + tokenExpiration).
     */
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // si tu utilises hashage, ici compare via BCryptPasswordEncoder.matches(...)
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        // Générer token
        String token = UUID.randomUUID().toString();
        LocalDateTime expires = LocalDateTime.now().plusHours(TOKEN_VALID_HOURS);

        user.setToken(token);
        user.setTokenExpiration(expires);

        userRepository.save(user);

        return user;
    }

    /**
     * Vérifie qu'un token est valide (existe et n'est pas expiré).
     */
    public boolean validateToken(String token) {
        if (token == null) return false;
        return userRepository.findByToken(token)
                .filter(u -> u.getTokenExpiration() != null && u.getTokenExpiration().isAfter(LocalDateTime.now()))
                .isPresent();
    }

    /**
     * Récupère l'utilisateur par token (utile pour un filtre d'authentification simple).
     */
    public User getByToken(String token) {
        return userRepository.findByToken(token).orElse(null);
    }
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // ou lever une exception si tu préfères
    }

    // méthodes CRUD supplémentaires si besoin...
}

