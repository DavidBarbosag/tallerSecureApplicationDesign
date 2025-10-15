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
}
