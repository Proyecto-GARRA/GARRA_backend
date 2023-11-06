package com.calendario.proyecto.backend.apirest.KEMLI.models.services.Empleado;

import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Cliente;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Empleado;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.TipoDeEmpleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> findAll();

    public  Empleado findById(Long id);

    public Empleado save (Empleado empleado);

    public void delete (Long id);


    //Listado tipos de empleados
    public List<TipoDeEmpleado> findAllTipoEmpleados();

    public List<Empleado> findPorNombre(String termino);

    public  List<Empleado> filtrarTecnico ();

}