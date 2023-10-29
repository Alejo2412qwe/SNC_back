package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comision")
public class Comision {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comId")
    private Long comId;

    @Column(name = "comDetalle")
    private String comDetalle;
    @Column(name = "comDesdeFecha")
    private Date comDesdeFecha;
    @Column(name = "comHastaFecha")
    private Date comHastaFecha;
    @Column(name = "comDias")
    private int comDias;
    @Column(name = "comLugar")
    private String comLugar;
    @Column(name = "comInforme")
    private String comInforme;
    @Column(name = "comEstado")
    private int comEstado;

    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuId;
}
