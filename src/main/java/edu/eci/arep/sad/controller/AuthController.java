package edu.eci.arep.sad.controller;

import edu.eci.arep.sad.model.User;
import edu.eci.arep.sad.security.JwtUtil;
import edu.eci.arep.sad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> user) {
        userService.registerUser(user.get("username"), user.get("password"));
        return "Usuario registrado correctamente";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        User dbUser = userService.findByUsername(user.get("username"))
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (userService.verifyPassword(user.get("password"), dbUser.getPassword())) {
            String token = jwtUtil.generateToken(dbUser.getUsername());
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
