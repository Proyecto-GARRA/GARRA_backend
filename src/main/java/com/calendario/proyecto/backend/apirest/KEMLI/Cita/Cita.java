package com.calendario.proyecto.backend.apirest.KEMLI.Cita;

import com.calendario.proyecto.backend.apirest.KEMLI.Cliente.Cliente;
import com.calendario.proyecto.backend.apirest.KEMLI.Empleado.Empleado;
import com.calendario.proyecto.backend.apirest.KEMLI.Reporte.Reporte;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "citas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
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

    // TODO: In production delete the 'columnDefintion' parameter, it's only for debuggin purposes
    @Column(nullable = false, columnDefinition = "ENUM('ACTIVA', 'CANCELADA', 'FINALIZADA') default 'ACTIVA'")
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado = EstadoEnum.ACTIVA;

    private static final long serialVersionUID = 1L;
}
