package pfe.centre_de_formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.centre_de_formation.dto.UserDTO;
import pfe.centre_de_formation.model.User;
import pfe.centre_de_formation.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // ---------------- Register ----------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
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
}
