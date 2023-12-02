package com.calendario.proyecto.backend.apirest.KEMLI.Rol;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
    Optional<Rol> findByName(RolEnum name);
}
