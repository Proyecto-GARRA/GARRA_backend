package com.calendario.proyecto.backend.apirest.KEMLI.Rol;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoolService {
    private RolRepository rolRepository;

    public List<Rol> getAllRoles() {
        return (List<Rol>) rolRepository.findAll();
    }

}
