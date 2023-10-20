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
    @Column(name = "permId")
    private Long permId;

    @Column(name = "permDocumento")
    private String permDocumento;
    @Column(name = "permTipo")
    private String permTipo;
    @Column(name = "permFecha")
    private Date permFecha;
    @Column(name = "permEstado")
    private boolean permEstado;
    @Column(name = "permCondicion")
    private String permCondicion;
    @Column(name = "permNumHoras")
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
