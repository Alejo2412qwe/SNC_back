package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Institucion")
public class Institucion implements Serializable {

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
    @Column(name = "insId")
    private Long insId;

    @Getter
    @Setter
    private String insNombre;

    @Getter
    @Setter
    private String intDireccion;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "tipId", referencedColumnName = "tipId")
    private TipoInstitucion tipId;

    @JsonIgnore
    @OneToMany(mappedBy = "insId")
    private List<Usuario> listaUsuarios;

}
