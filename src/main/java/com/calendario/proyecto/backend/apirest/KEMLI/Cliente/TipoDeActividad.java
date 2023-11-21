package com.calendario.proyecto.backend.apirest.KEMLI.Cliente;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "tipos_de_actividades")

public class TipoDeActividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_actividad")
    private String tipoActividad;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    private static final long serialVersionUID = 1L;

}
