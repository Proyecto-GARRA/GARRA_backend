package com.calendario.proyecto.backend.apirest.KEMLI.Cita.Exceptions;

public class CitaNotFoundException extends Exception{
    public CitaNotFoundException(long id) {
        super("Error: cita con " + id + " no encontrada.");
    }
}
