package com.ejemplos.seguridad2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ejemplos.seguridad2.model.Usuario;


public interface usuarioRepository extends CrudRepository<Usuario,Integer>{
    Optional<Usuario> findByUsername(String username);
}
