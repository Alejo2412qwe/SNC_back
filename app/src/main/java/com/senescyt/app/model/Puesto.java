package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Puesto")
public class Puesto /*cargo*/ implements Serializable {

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
    @Column(name = "pueId")
    private Long pueId;

    @Getter
    @Setter
    @Column(name = "pueNombre")
    private String pueNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "pueId")
    private List<CargoUsuario> listaCargoUsuarios;
}
