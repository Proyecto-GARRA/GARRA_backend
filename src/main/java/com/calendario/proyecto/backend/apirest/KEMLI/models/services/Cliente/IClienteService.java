package com.calendario.proyecto.backend.apirest.KEMLI.models.services.Cliente;

import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List <Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente save (Cliente cliente);

    public void delete (Long id);

    public List<Cliente> findPorNombre(String termino);

}
