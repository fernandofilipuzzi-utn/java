package com.ejemplos.seguridad2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.seguridad2.model.AuthResponse;
import com.ejemplos.seguridad2.model.LoginRequest;
import com.ejemplos.seguridad2.model.RegisterRequest;
import com.ejemplos.seguridad2.service.AuthServiceImpl;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthServiceImpl authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    // en este caso se crea un nuevo registro de usuario
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
