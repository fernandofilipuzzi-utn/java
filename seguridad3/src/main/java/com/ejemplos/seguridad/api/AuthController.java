package com.ejemplos.seguridad.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.seguridad.model.AuthResponse;
import com.ejemplos.seguridad.model.LoginRequest;
import com.ejemplos.seguridad.model.RegisterRequest;
import com.ejemplos.seguridad.service.AuthServiceImpl;

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
