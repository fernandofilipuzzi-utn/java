package com.ejemplos.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ejemplos.seguridad.model.AuthResponse;
import com.ejemplos.seguridad.model.LoginRequest;
import com.ejemplos.seguridad.model.RegisterRequest;
import com.ejemplos.seguridad.model.Role;
import com.ejemplos.seguridad.model.Usuario;
import com.ejemplos.seguridad.repository.usuarioRepository;

import org.springframework.security.core.userdetails.UserDetails;

@Service
public class AuthServiceImpl {

    @Autowired
    usuarioRepository userRepository;

    @Autowired
    JwtService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;


    public AuthResponse  login(LoginRequest request) 
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest request) 
    {
       Usuario user = new Usuario(
    		   		request.getUsername(),
    		   		passwordEncoder.encode(request.getPassword()),
    		   		request.getFirstname(),
    		   		request.getLastname(),
    		   		request.getCountry(),
    		   		Role.USER
    		   		);
                
        userRepository.save(user);
        return new AuthResponse(jwtService.getToken(user));
    }
}