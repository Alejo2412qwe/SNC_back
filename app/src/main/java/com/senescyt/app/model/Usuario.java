/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ALEJO PC
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuId")
    private Long usuId;

    private String usuNombreUsuario;
    private String usuContrasena;
    private Long usuIdHuella;
    private String usuCorreo;
    private String usuTokenPassword;
    private int usuEstado;
    private Timestamp usuFechaRegistro;

    @OneToOne
    @JoinColumn(name = "usuPerId")
    private Persona usuPerId;

    @ManyToOne
    @JoinColumn(name = "rolId", referencedColumnName = "rolId")
    private Rol rolId;

    @ManyToOne
    @JoinColumn(name = "funId", referencedColumnName = "funId")
    private Funciones funId;

    @ManyToOne
    @JoinColumn(name = "insId", referencedColumnName = "insId")
    private Institucion insId;

    @JsonIgnore
    @OneToMany(mappedBy = "usuId")
    private List<CargoUsuario> listaCargoUsuarios;

    @JsonIgnore
    @OneToMany(mappedBy = "usuId")
    private List<Asistencia> listaAsistencia;

    @JsonIgnore
    @OneToMany(mappedBy = "usuId")
    private List<Permisos> listaPermisos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuId")
    private List<Vacaciones> listaVacaciones;

}
