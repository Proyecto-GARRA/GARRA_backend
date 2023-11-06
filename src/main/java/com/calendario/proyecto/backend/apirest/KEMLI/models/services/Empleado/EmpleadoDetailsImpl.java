package com.calendario.proyecto.backend.apirest.KEMLI.models.services.Empleado;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Empleado;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmpleadoDetailsImpl implements UserDetails {

    private Long id;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public EmpleadoDetailsImpl(Long id, String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static EmpleadoDetailsImpl build(Empleado empleado) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(empleado.getTipoDeEmpleado().getTipoEmpleado());
        List<GrantedAuthority> authorities = Arrays.asList(authority);
        return new EmpleadoDetailsImpl(empleado.getId(), empleado.getCorreo(), empleado.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this == null || getClass() != obj.getClass())
            return false;

        EmpleadoDetailsImpl empleado = (EmpleadoDetailsImpl) obj;
        return Objects.equals(id, empleado.id);
    }
}
