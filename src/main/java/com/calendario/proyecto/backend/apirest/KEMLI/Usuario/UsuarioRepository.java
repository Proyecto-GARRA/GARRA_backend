package com.calendario.proyecto.backend.apirest.KEMLI.Usuario;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
}