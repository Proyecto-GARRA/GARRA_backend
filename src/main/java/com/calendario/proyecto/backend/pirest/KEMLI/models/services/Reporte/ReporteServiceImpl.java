package com.calendario.proyecto.backend.pirest.KEMLI.models.services.Reporte;

import com.calendario.proyecto.backend.pirest.KEMLI.models.dao.IReporteDao;
import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReporteServiceImpl implements IReporteService {

    @Autowired
    private IReporteDao reporteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reporte> findAll() {
        return (List<Reporte>) reporteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reporte findById(Long id) {
        return reporteDao.findById(id).orElse(null);
    }

    @Override
    public Reporte save(Reporte reporte) {
        return reporteDao.save(reporte);
    }

    @Override
    public void deleteById(Long id) {
        reporteDao.deleteById(id);
    }


}
