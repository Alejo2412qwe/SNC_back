package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Permisos")
public class Permisos implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permId;

    private String permDocumento;
    private String permTipo;
    private Date permFecha;
    private boolean permEstado;
    private String permCondicion;
    private int permNumHoras;

    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuId;

    @JsonIgnore
    @OneToMany(mappedBy = "permId")
    private List<TipoFormulario> listaTipoFormulario;

    @JsonIgnore
    @OneToMany(mappedBy = "permId")
    private List<TipoPermiso> listTipoPermiso;

}
