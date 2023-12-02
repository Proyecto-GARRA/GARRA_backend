package com.calendario.proyecto.backend.apirest.KEMLI.Rol;

public class RolNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;
    public RolNotFoundException() {
        super("Rol not founded");
    }
}
