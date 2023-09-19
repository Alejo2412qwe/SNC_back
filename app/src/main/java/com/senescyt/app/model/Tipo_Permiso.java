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
@Table(name = "Tipo_Permiso")
public class Tipo_Permiso {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tpPermiso;

    private String nombre_tperm;
    private boolean estado_tperm;

    @JsonIgnore
    @OneToMany(mappedBy = "id_tpPermiso")
    private List<Permisos> listaPermisos;
}
