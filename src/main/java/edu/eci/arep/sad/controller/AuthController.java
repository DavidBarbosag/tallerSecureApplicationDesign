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
        try {
            System.out.println("🟢 Intentando login con usuario: " + user.get("username"));
            boolean ok = userService.login(user.get("username"), user.get("password"));
            if (ok) {
                return Map.of("message", "Login exitoso");
            } else {
                return Map.of("error", "Credenciales inválidas");
            }
        } catch (Exception e) {
            e.printStackTrace(); // 👈 Esto mostrará la causa real en app.log
            return Map.of("error", "Error interno: " + e.getMessage());
        }
    }
}
