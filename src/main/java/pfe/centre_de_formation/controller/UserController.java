package pfe.centre_de_formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pfe.centre_de_formation.dto.UserDTO;
import pfe.centre_de_formation.model.User;
import pfe.centre_de_formation.repository.UserRepository;
import pfe.centre_de_formation.service.UserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        // Convertir en DTO pour ne pas exposer le mot de passe
        List<UserDTO> dtos = users.stream()
                .map(UserDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }
    // ---------------- Get user by ID ----------------
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);

            // Ne jamais exposer le mot de passe
            user.setPassword(null);

            UserDTO dto = new UserDTO(user);
            return ResponseEntity.ok(dto);

        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }


    // ---------------- Register ----------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        System.out.println("Spetialite reçu : " + user.getSpecialite());

        try {
            User created = userService.register(user);

            // masque le mot de passe
            created.setPassword(null);

            // convertir en DTO pour renvoyer un JSON propre
            UserDTO userDTO = new UserDTO(created);
            return ResponseEntity.ok(userDTO);

        } catch (RuntimeException ex) {
            Map<String, String> err = new HashMap<>();
            err.put("error", ex.getMessage());
            return ResponseEntity.badRequest().body(err);
        }
    }

    // ---------------- Login ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        try {
            User user = userService.login(email, password);

            // masque le mot de passe
            user.setPassword(null);

            // convertir en DTO
            UserDTO userDTO = new UserDTO(user);

            // renvoyer le token + DTO
            Map<String, Object> res = new HashMap<>();
            res.put("token", user.getToken());
            res.put("user", userDTO);

            return ResponseEntity.ok(res);

        } catch (RuntimeException ex) {
            Map<String, String> err = new HashMap<>();
            err.put("error", ex.getMessage());
            return ResponseEntity.status(401).body(err);
        }
    }

    // ---------------- Logout ----------------
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String,String> body) {
        String token = body.get("token");
        User u = userService.getByToken(token);
        if (u != null) {
            u.setToken(null);
            u.setTokenExpiration(null);
            userService.register(u); // save changes

            Map<String,String> ok = new HashMap<>();
            ok.put("message","logged out successfully");
            return ResponseEntity.ok(ok);

        } else {
            Map<String,String> err = new HashMap<>();
            err.put("error","token not found");
            return ResponseEntity.badRequest().body(err);
        }
    }
    @PostMapping("/upload-cv")
    public ResponseEntity<?> uploadCv(
            @RequestParam("userId") Long userId,
            @RequestParam("cvFile") MultipartFile cvFile
    ) {
        if (cvFile.isEmpty()) {
            return ResponseEntity.badRequest().body("Le fichier CV est vide");
        }

        try {
            String uploadDir = "uploads/cv/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = cvFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.write(filePath, cvFile.getBytes());

            User user = userService.getById(userId);
            if (user == null) {
                return ResponseEntity.badRequest().body("Utilisateur non trouvé");
            }

            user.setCvPath(filePath.toString());
            userRepository.save(user); // <-- IMPORTANT : Update au lieu de register()

            return ResponseEntity.ok("CV uploadé avec succès");

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erreur lors de l'upload du CV : " + e.getMessage());
        }
    }


}
