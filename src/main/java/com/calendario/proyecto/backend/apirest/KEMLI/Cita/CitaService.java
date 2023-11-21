package com.calendario.proyecto.backend.apirest.KEMLI.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calendario.proyecto.backend.apirest.KEMLI.Cliente.TipoDeActividad;

import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) citaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cita findById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Transactional
    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    @Transactional
    public void delete(Long id) {
        citaRepository.deleteById(id);
    }

    public List<TipoDeActividad> findAllTipoActividades() {
        return citaRepository.findAllTipoActividades();
    }

    @Transactional(readOnly = true)
    public List<Cita> filtradoDeNombreCliente(String termino) {
        return citaRepository.filtradoDeNombreCliente(termino);
    }

    public List<Cita> filtradoDeNombreEmpleado(String termino_nombre_empleado) {
        return citaRepository.filtradoDeNombreEmpleado(termino_nombre_empleado);
    }


}
