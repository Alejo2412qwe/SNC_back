package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Subprocesos")
public class Subprocesos /*departamento*/ implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subId")
    private Long subId;

    @Getter
    @Setter
    @Column(name = "subNombre")
    private String subNombre;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "procId", referencedColumnName = "procId")
    private Procesos procId;

    @JsonIgnore
    @OneToMany(mappedBy = "subId")
    private List<Asistencia> listaAsistencia;
}
