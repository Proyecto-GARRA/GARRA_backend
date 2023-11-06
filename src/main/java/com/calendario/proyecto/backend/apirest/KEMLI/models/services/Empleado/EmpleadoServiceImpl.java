package com.calendario.proyecto.backend.apirest.KEMLI.models.services.Empleado;

import com.calendario.proyecto.backend.apirest.KEMLI.models.dao.IEmpleadoDao;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Cliente;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Empleado;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.TipoDeEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private IEmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        empleadoDao.deleteById(id);
    }

    @Override
    public List<TipoDeEmpleado> findAllTipoEmpleados() {
        return empleadoDao.findAllTipoEmpleados();
    }

    @Override
    @Transactional
    public List<Empleado> findPorNombre(String termino) {
        return empleadoDao.filtradoPorNombre(termino);
    }

    @Override
    public List<Empleado> filtrarTecnico() {
        return empleadoDao.filtrarTecnico();
    }
}
