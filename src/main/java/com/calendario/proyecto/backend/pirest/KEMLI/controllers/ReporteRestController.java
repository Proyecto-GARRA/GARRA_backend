package com.calendario.proyecto.backend.pirest.KEMLI.controllers;

import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.Reporte;
import com.calendario.proyecto.backend.pirest.KEMLI.models.services.Reporte.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReporteRestController {
    @Autowired
    private IReporteService reporteService;

    @GetMapping("/reportes")
    public List<Reporte> index (){
        return reporteService.findAll();
    }
}
