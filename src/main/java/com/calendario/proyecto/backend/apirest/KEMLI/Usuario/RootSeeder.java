package com.calendario.proyecto.backend.apirest.KEMLI.Usuario;

import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.calendario.proyecto.backend.apirest.KEMLI.Rol.Rol;
import com.calendario.proyecto.backend.apirest.KEMLI.Rol.RolEnum;
import com.calendario.proyecto.backend.apirest.KEMLI.Rol.RolRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RootSeeder implements ApplicationListener<ContextRefreshedEvent>{

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.loadRoot();
    }

    private void loadRoot() {
        Optional<Rol> rootRol = rolRepository.findByName(RolEnum.ROOT);
        Optional<Usuario> rootUsr = usuarioRepository.findByUsername("root");

        rootUsr.ifPresentOrElse(System.out::print, () -> {
            Usuario root = Usuario.builder()
                        .username("root")
                        .password(passwordEncoder.encode("12345"))
                        .rol(rootRol.get())
                        .build();
            usuarioRepository.save(root);
        });
    }

}
