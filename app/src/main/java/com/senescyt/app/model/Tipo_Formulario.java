package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tipo_Formulario")
public class Tipo_Formulario {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_TipoFormulario;

    private String nombre_tpform;
    private String documento_tpform;

    @JsonIgnore
    @OneToMany(mappedBy = "id_TipoFormulario")
    private List<Permisos> listaPermisos;
}
