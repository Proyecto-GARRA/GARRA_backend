package com.calendario.proyecto.backend.apirest.KEMLI.Empleado;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

    @Query("from TipoDeEmpleado")
    public List<TipoDeEmpleado> findAllTipoEmpleados();

    @Query("select empl from Empleado empl where concat(' ', empl.nombreDelEmpleado, ' ', empl.apellido_P, ' ', empl.apellido_M) like %?1%")
    public List<Empleado> filtradoPorNombre(String termino);

    @Query("select tecnicos from Empleado tecnicos where tecnicos.tipoDeEmpleado = '1'")
    public  List<Empleado> filtrarTecnico();

}
