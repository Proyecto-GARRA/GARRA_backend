package com.calendario.proyecto.backend.apirest.KEMLI.Empleado;

import com.calendario.proyecto.backend.apirest.KEMLI.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "empleados")
@Data
public class Empleado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 20, message = "El tamaño debe de estar entre 3 y 20")
    @Column(name = "nombre_empleado")
    private String nombreDelEmpleado;

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 15, message = "El tamañop debe de estar entre 3 y 15")
    @Column(name = "apellido_paterno")
    private String apellido_P;
    
    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 15, message = "El tamañop debe de estar entre 3 y 15")
    @Column(name = "apellido_materno")
    private String apellido_M;
    
    @NotNull(message = "No puede estar vacio")
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecha_naci;
    
    @NotEmpty(message = "No puede estar vacio")
    private String domicilio;
    
    @NotEmpty(message = "No puede estar vacio")
    @Email(message = "No es una direccion de correo")
    @Column(nullable = false, unique = true)
    private String correo;
    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 10, max = 10, message = "No puede tener menos de 10 digitos y no puede pasar de 10 digitos")
    @Pattern(regexp = "^[0-9-]+$", message = "El número de teléfono solo debe contener dígitos numericos")
    private String telefono;
    
    @NotNull( message = "El tipo de empleado no puede estar vacia")
    @ManyToOne
    @JoinColumn(name = "tipo_de_empleado_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoDeEmpleado tipoDeEmpleado;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;
    
    private static final long serialVersionUID = 1L;
}
