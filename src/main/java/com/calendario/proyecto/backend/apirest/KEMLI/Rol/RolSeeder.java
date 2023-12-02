package com.calendario.proyecto.backend.apirest.KEMLI.Rol;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/*
 * A seeder is a class that crates predefined data for a table in a
 * database.
*/
@Component
public class RolSeeder implements ApplicationListener<ContextRefreshedEvent>{

    private final RolRepository rolRepository;

    public RolSeeder(RolRepository rolRepository) {
        this.rolRepository  = rolRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.loadRoles();
    }

    private void loadRoles() {
        RolEnum[] rolNames = new RolEnum[] {RolEnum.ROOT, RolEnum.ADMIN, RolEnum.USER};

        Arrays.stream(rolNames).forEach((roleName) -> {
            Optional<Rol> optionalRol = rolRepository.findByName(roleName);

            // If the role alrdeady exists in the database just print his name
            // otherwise create the new role.
            optionalRol.ifPresentOrElse(System.out::print, () -> {
                Rol newRol = new Rol();
                newRol.setName(roleName);

                rolRepository.save(newRol);
            });
        });
    }

}
