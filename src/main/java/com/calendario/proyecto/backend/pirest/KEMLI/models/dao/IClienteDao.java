package com.calendario.proyecto.backend.pirest.KEMLI.models.dao;

import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

    //MODO MANUAL
    @Query("select cli from Cliente cli where concat(' ', cli.nombreDelCliente, ' ', cli.apellido_P, ' ', cli.apellido_M) like %?1%")
    public List<Cliente> filtradoPorNombre(String termino);

}
