package com.calendario.proyecto.backend.pirest.KEMLI.models.services.Reporte;

import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.Reporte;

import java.util.List;

public interface IReporteService {

    public List<Reporte> findAll();

    public  Reporte findById(Long id);

    public  Reporte save (Reporte reporte);

    public void deleteById (Long id);
}
