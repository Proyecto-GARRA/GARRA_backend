package com.calendario.proyecto.backend.apirest.KEMLI.Cita.Exceptions;

public class StateNotFoundException extends Exception{

    public StateNotFoundException(String name) {
        super("Error: estado " + name +" no encontrado.");
    }
}
