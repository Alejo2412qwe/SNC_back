package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Permisos")
public class Permisos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_permiso;

    private String documento_perm;
    private String tipo_perm;
    private Date fecha_perm;
    private boolean estado_perm;
    private String condicion_perm;
    private int n_horas_perm;

    @ManyToOne
    @JoinColumn(name = "id_tpFormulario", referencedColumnName = "id_tpFormulario")
    private Tipo_Formulario id_tpFormulario;

    @ManyToOne
    @JoinColumn(name = "id_tpFormulario", referencedColumnName = "id_tpFormulario")
    private Tipo_Permiso id_tpPermiso;

    @JsonIgnore
    @OneToMany(mappedBy = "id_permiso")
    private List<Usuario> listaUsuarios;
}
