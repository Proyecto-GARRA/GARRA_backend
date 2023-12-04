package com.calendario.proyecto.backend.apirest.KEMLI.Rol;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RolController {
    RoolService roolService;

    @GetMapping()
    public List<Rol> getAll() {
        return roolService.getAllRoles();
    }
}
