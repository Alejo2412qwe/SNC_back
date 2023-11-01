package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Permisos")
public class Permisos implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permId")
    private Long permId;

    @Column(name = "permObservacion", length = 1000)
    private String permObservacion;
    @Column(name = "permFechaInicio")
    private Date permFechaInicio;
    @Column(name = "permFechaFin")
    private Date permFechaFin;
    @Column(name = "permEstado")
    private char permEstado;
    @Column(name = "permHorasInicio")
    private Timestamp permHorasInicio;
    @Column(name = "permHorasFin")
    private Timestamp permHorasFin;

    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuId;

    @ManyToOne
    @JoinColumn(name = "tiFoId", referencedColumnName = "tiFoId")
    private TipoFormulario tiFoId;

    @ManyToOne
    @JoinColumn(name = "motId", referencedColumnName = "motId")
    private MotivoPermiso motId;

    @ManyToOne
    @JoinColumn(name = "tiPeId", referencedColumnName = "tiPeId")
    private TipoPermiso tiPeId;

    @ManyToOne
    @JoinColumn(name = "regId", referencedColumnName = "regId")
    private Regimen regId;

}
