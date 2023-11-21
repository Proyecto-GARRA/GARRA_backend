package com.calendario.proyecto.backend.apirest.KEMLI.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Empleado findById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Transactional
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }

    public List<TipoDeEmpleado> findAllTipoEmpleados() {
        return empleadoRepository.findAllTipoEmpleados();
    }

    @Transactional
    public List<Empleado> findPorNombre(String termino) {
        return empleadoRepository.filtradoPorNombre(termino);
    }

    public List<Empleado> filtrarTecnico() {
        return empleadoRepository.filtrarTecnico();
    }
}
