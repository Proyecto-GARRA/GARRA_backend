package com.calendario.proyecto.backend.apirest.KEMLI.Reporte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    @Transactional(readOnly = true)
    public List<Reporte> findAll() {
        return (List<Reporte>) reporteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Reporte findById(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public void deleteById(Long id) {
        reporteRepository.deleteById(id);
    }

}
