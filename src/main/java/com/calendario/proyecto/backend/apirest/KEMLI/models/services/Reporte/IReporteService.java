package com.calendario.proyecto.backend.apirest.KEMLI.models.services.Reporte;

import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Reporte;

import java.util.List;

public interface IReporteService {

    public List<Reporte> findAll();

    public  Reporte findById(Long id);

    public  Reporte save (Reporte reporte);

    public void deleteById (Long id);
}
