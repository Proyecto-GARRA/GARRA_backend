package com.calendario.proyecto.backend.apirest.KEMLI.Cliente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("select cli from Cliente cli where concat(' ', cli.nombreDelCliente, ' ', cli.apellido_P, ' ', cli.apellido_M) like %?1%")
    public List<Cliente> filtradoPorNombre(String termino);

}
