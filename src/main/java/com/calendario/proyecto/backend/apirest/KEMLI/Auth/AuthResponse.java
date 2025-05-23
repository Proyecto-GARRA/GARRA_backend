package com.calendario.proyecto.backend.apirest.KEMLI.Auth;

import com.calendario.proyecto.backend.apirest.KEMLI.Rol.RolEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Respuesta de la request, ya sea del login o del registro.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
    String username;
    RolEnum rol;
}
