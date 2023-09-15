package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EstadoAsistencia")
public class EstadoAsistencia implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estId")
    private Long estId;

    @Getter
    @Setter
    @Column(name = "estNombre")
    private String estNombre;

    @Getter
    @Setter
    @Column(name = "estEstado")
    private boolean estEstado;

    @JsonIgnore
    @OneToMany(mappedBy = "estId")
    private List<Asistencia> listaAsistencia;
}
