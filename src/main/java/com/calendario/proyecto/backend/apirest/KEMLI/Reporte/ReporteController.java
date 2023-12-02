package com.calendario.proyecto.backend.apirest.KEMLI.Reporte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Reporte> obtenerReportes() {
        return reporteService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> crearReporte(@RequestBody Reporte reporte) {
        try {
            // Aquí podrías agregar validaciones o lógica adicional antes de guardar el reporte
            reporteService.save(reporte);
            return new ResponseEntity<>("Reporte creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el reporte: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
