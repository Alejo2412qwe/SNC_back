package com.senescyt.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asisId")
    private Long asisId;

    @Column(name = "asisNombre")
    private String asisNombre;

    @Column(name = "asisVerificacion")
    private String asisVerificacion;

    @Column(name = "asisEstado")
    private boolean asisEstado;

    @Column(name = "asisLector")
    private int asisLector;

    @Column(name = "asisFecha")
    private String asisFecha;

    @Column(name = "asisHoraMarcado")
    private String asisHoraMarcado;

    @ManyToOne
    @JoinColumn(name = "subId", referencedColumnName = "subId")
    private Subprocesos subId;

    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuId;

    @ManyToOne
    @JoinColumn(name = "estId", referencedColumnName = "estId")
    private EstadoAsistencia estadoAsistencia;

}
