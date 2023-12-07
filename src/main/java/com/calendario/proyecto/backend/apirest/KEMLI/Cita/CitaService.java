package com.calendario.proyecto.backend.apirest.KEMLI.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calendario.proyecto.backend.apirest.KEMLI.Cita.Exceptions.CitaNotFoundException;
import com.calendario.proyecto.backend.apirest.KEMLI.Cita.Exceptions.StateNotFoundException;

import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public List<Cita> findFinished(){
        return citaRepository.filtradoCitasInactivas();
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

    public void changeCitaState(long id, String state) throws Exception{
        final Cita cita = findById(id);
        final List<String> states = List.of(EstadoEnum.ACTIVA.name(), EstadoEnum.FINALIZADA.name(), EstadoEnum.CANCELADA.name());
        if(!states.contains(state)) {
            throw new StateNotFoundException(state);
        }
        EstadoEnum stateEnum = EstadoEnum.valueOf(state);

        try {
            cita.setEstado(stateEnum);
            citaRepository.save(cita);
        } catch(Exception e){
            throw new CitaNotFoundException(id);
        }
    }


}
