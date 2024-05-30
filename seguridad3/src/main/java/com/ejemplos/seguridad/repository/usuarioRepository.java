package com.ejemplos.seguridad.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ejemplos.seguridad.model.Usuario;


public interface usuarioRepository extends CrudRepository<Usuario,Integer>{
    Optional<Usuario> findByUsername(String username);
}
