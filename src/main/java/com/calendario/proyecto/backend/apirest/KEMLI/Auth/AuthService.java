package com.calendario.proyecto.backend.apirest.KEMLI.Auth;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.calendario.proyecto.backend.apirest.KEMLI.Rol.Rol;
import com.calendario.proyecto.backend.apirest.KEMLI.Rol.RolEnum;
import com.calendario.proyecto.backend.apirest.KEMLI.Rol.RolNotFoundException;
import com.calendario.proyecto.backend.apirest.KEMLI.Rol.RolRepository;
import com.calendario.proyecto.backend.apirest.KEMLI.Usuario.Usuario;
import com.calendario.proyecto.backend.apirest.KEMLI.Usuario.UsuarioRepository;
import com.calendario.proyecto.backend.apirest.KEMLI.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) throws RolNotFoundException {
        Optional<Rol> rol = rolRepository.findByName(RolEnum.USER);
        return rol.map((r) -> {
                System.out.println(rol);
                Usuario usuario = Usuario.builder()
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .rol(r)
                        .build();
                usuarioRepository.save(usuario);
                return AuthResponse.builder()
                        .token(jwtService.getToken(usuario))
                        .build();
        }).orElseThrow(RolNotFoundException::new);
    }
}
