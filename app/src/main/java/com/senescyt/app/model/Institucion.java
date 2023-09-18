package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insId;

    private String insNombre;
    private String intDireccion;

    @ManyToOne
    @JoinColumn(name = "tipId", referencedColumnName = "tipId")
    private TipoInstitucion tipId;

    @JsonIgnore
    @OneToMany(mappedBy = "insId")
    private List<Usuario> listaUsuarios;

}
