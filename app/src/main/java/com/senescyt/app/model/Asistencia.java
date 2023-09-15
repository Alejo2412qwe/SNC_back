package com.senescyt.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Asistencia")
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

    @Getter
    @Setter
    @Column(name = "asisNombre")
    private String asisNombre;

    @Getter
    @Setter
    @Column(name = "asisVerificacion")
    private String asisVerificacion;

    @Getter
    @Setter
    @Column(name = "asisEstado")
    private boolean asisEstado;

    @Getter
    @Setter
    @Column(name = "asisLector")
    private int asisLector;

    @Getter
    @Setter
    @Column(name = "asisFecha")
    private String asisFecha;

    @Getter
    @Setter
    @Column(name = "asisHoraMarcado")
    private String asisHoraMarcado;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "subId", referencedColumnName = "subId")
    private Subprocesos subId;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuId;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "estId", referencedColumnName = "estId")
    private EstadoAsistencia estId;

}
