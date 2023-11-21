package com.calendario.proyecto.backend.apirest.KEMLI.Cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 15)
    @Column(name = "nombre_cliente")
    private String nombreDelCliente;


    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 15)
    @Column(name = "apellido_paterno")
    private String apellido_P;

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 15)
    @Column (name = "apellido_materno")
    private String apellido_M;

    @NotNull(message = "No puede estar vacio")
    @Column (name = "fecha_nacimineto")
    @Temporal(TemporalType.DATE)
    private Date fecha_naci;

    @NotEmpty(message = "No puede estar vacio")
    private String domicilio;

    @NotEmpty(message = "No puede estar vacio")
    @Email(message = "No es una direccion de correo")
    @Column(nullable = false ,unique = true)
    private String correo;
    
    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 10, max = 10, message = "No puede tener menos de 10 digitos y no puede pasar de 10 digitos")
    @Pattern(regexp = "^[0-9-]+$", message = "El número de teléfono solo debe contener dígitos numericos")
    private String telefono;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public String getApellido_P() {
        return apellido_P;
    }

    public void setApellido_P(String apellido_P) {
        this.apellido_P = apellido_P;
    }

    public String getApellido_M() {
        return apellido_M;
    }

    public void setApellido_M(String apellido_M) {
        this.apellido_M = apellido_M;
    }

    public Date getFecha_naci() {
        return fecha_naci;
    }

    public void setFecha_naci(Date fecha_naci) {
        this.fecha_naci = fecha_naci;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}




