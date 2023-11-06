package com.calendario.proyecto.backend.apirest.KEMLI.models.services.Cita;

import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Cita;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.TipoDeActividad;

import java.util.List;

public interface ICitaService {

    //Obtener todas las citas
    public List<Cita> findAll();

    //Buscar una cita mediante id
    public Cita findById(Long id);

    //Guardar una cita
    public Cita save (Cita cita);

    //Eliminar una cita
    public void delete (Long id);

    //LISTADO DE TIPO DE ACTIVIDADES
    public List<TipoDeActividad> findAllTipoActividades();

    //Busqueda de clientes
    public List<Cita> filtradoDeNombreCliente(String termino);

    //busqueda de empleados
    public List<Cita>filtradoDeNombreEmpleado(String termino_nombre_empleado);

}
