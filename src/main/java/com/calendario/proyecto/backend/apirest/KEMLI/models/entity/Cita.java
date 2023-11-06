package com.calendario.proyecto.backend.apirest.KEMLI.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "citas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "No puede estar vacio")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCita")
    private Date fecha_cita;

    @NotNull(message = "No puede estar vacio")
    @Temporal(TemporalType.TIME)
    @Column(name = "horaCita")
    private String hora_cita;

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 200)
    @Column(name = "direccion")
    private String direccion;

    @NotEmpty(message = "No puede estar vacio")
    @Size(min = 3, max = 200)
    private String descripcion;

    @NotNull( message = "No puede estar vacia")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull( message = "No puede estar vacia")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @NotNull( message = "No puede estar vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_de_actividad_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoDeActividad tipoDeActividad;

    @OneToOne (mappedBy = "cita", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JsonIgnoreProperties({"cita"})
    private Reporte reporte;

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hora_cita) {
        this.hora_cita = hora_cita;
    }

    public TipoDeActividad getTipoDeActividad() {
        return tipoDeActividad;
    }

    public void setTipoDeActividad(TipoDeActividad tipoDeActividad) {
        this.tipoDeActividad = tipoDeActividad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private static final long serialVersionUID = 1L;
}
