package com.calendario.proyecto.backend.apirest.KEMLI.Rol;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "roles")
@Entity
@Data
public class Rol implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RolEnum name;

}
