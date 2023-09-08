package com.senescyt.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asiId")
    private Long asiId;

    @Column(name = "asiUsuario")
    private String asiUsuario;

    @Column(name = "asiFecha")
    private Date asiFecha;

    @Column(name = "asiRol")
    private int asiRol;

    @Column(name = "asiTipoAsistencia")
    private int asiTipoAsistencia;

    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuIdHuella;

}
