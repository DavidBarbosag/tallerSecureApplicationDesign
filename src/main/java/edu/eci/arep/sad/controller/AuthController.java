package edu.eci.arep.sad.controller;

import edu.eci.arep.sad.model.User;
import edu.eci.arep.sad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> user) {
        userService.registerUser(user.get("username"), user.get("password"));
        return "Usuario registrado correctamente";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");

        try {
            boolean ok = userService.login(username, password);
            if (ok) {
                return Map.of("message", "Login exitoso");
            } else {
                return Map.of("error", "Credenciales inválidas");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", "Error interno: " + e.getMessage());
        }
    }
}
