package com.calendario.proyecto.backend.apirest.KEMLI.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "tipos_de_empleados")

public class TipoDeEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_empleado")
    private String tipoEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    private static final long serialVersionUID = 1L;

}
