package com.calendario.proyecto.backend.apirest.KEMLI.Reporte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    @GetMapping("/reportes")
    public List<Reporte> index (){
        return reporteService.findAll();
    }
}
