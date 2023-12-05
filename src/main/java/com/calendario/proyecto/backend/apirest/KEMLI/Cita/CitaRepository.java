package com.calendario.proyecto.backend.apirest.KEMLI.Cita;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitaRepository extends CrudRepository<Cita, Long> {

    //CONSULTA DEL TIPO DE ACTIVIDAD
    @Query("from TipoDeActividad")
    public List<TipoDeActividad> findAllTipoActividades();

    //CONSULTA DEL NOMBRE DEL EMPLEADO
    @Query("SELECT c FROM Cita c WHERE CONCAT(c.cliente.nombreDelCliente, ' ', c.cliente.apellido_P, ' ', c.cliente.apellido_M) LIKE %?1%")
    public List<Cita>filtradoDeNombreCliente (String termino);

    @Query(value = "SELECT c FROM Cita c WHERE CONCAT(c.empleado.nombreDelEmpleado, ' ', c.empleado.apellido_P, ' ', c.empleado.apellido_M) LIKE %?1%")
    //@Query("select c from  Cita c where c.empleado.nombreDelEmpleado like %?1% or c.empleado.apellido_P like %?1% or c.empleado.apellido_M like %?1%")
    public List<Cita>filtradoDeNombreEmpleado(String termino_nombre_empleado);

    @Query(value = "SELECT c FROM Cita c WHERE c.estado NOT LIKE 'ACTIVA'")
    public List<Cita>filtradoCitasInactivas();


    //CONSULTA DE TECNICOS
    //@Query("")
    //public List<Cita>filtarTacnicos();
}
