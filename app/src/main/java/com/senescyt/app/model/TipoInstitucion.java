package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TipoInstitucion")
public class TipoInstitucion implements Serializable {

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
    @Column(name = "tipId")
    private Long tipId;

    @Getter
    @Setter
    @Column(name = "tipNombre")
    private String tipNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "tipId")
    private List<Institucion> listaInstituciones;
}
