package com.calendario.proyecto.backend.pirest.KEMLI.models.services.Cita;

import com.calendario.proyecto.backend.pirest.KEMLI.models.dao.ICitaDao;
import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.Cita;
import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.TipoDeActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitaServiceImpl implements  ICitaService{

    @Autowired
    private ICitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) citaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cita findById(Long id) {
        return citaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cita save(Cita cita) {
        return citaDao.save(cita);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        citaDao.deleteById(id);
    }

    @Override
    @Transactional
    public List<TipoDeActividad> findAllTipoActividades() {
        return citaDao.findAllTipoActividades();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> filtradoDeNombreCliente(String termino) {
        return citaDao.filtradoDeNombreCliente(termino);
    }

    @Override
    public List<Cita> filtradoDeNombreEmpleado(String termino_nombre_empleado) {
        return citaDao.filtradoDeNombreEmpleado(termino_nombre_empleado);
    }


}
