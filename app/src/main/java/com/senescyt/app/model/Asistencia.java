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
    private Long asisId;

    private String asisNombre;
    private String asisVerificacion;
    private boolean asisEstado;
    private int asisLector;
    private String asisFecha;
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
