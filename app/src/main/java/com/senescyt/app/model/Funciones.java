package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Funciones")
public class Funciones implements Serializable {

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
    @Column(name = "funId")
    private Long funId;

    @Getter
    @Setter
    @Column(name = "funId")
    private String funNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "funId")
    private List<Usuario> listaUsuarios;

}
