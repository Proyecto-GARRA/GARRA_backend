package com.calendario.proyecto.backend.apirest.KEMLI.Cita;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CitaRequest {
    String fecha;
    String estado;
}
