package com.calendario.proyecto.backend.apirest.KEMLI.models.services.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.calendario.proyecto.backend.apirest.KEMLI.models.dao.IEmpleadoDao;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Empleado;

import jakarta.transaction.Transactional;

public class EmpleadoDetailsServiceImpl implements UserDetailsService{
    @Autowired
    IEmpleadoDao empleadoDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Empleado empleado = empleadoDao.findByCorreo(email).orElseThrow(() -> new UsernameNotFoundException("Employee not found with given email"));
        return EmpleadoDetailsImpl.build(empleado);
    }
    
}
