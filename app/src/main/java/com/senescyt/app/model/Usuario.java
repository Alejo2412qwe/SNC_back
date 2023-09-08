/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senescyt.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALEJO PC
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

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
    @Column(name = "usuId")
    private Long usuId;

    @Getter
    @Setter
    @Column(name = "usuNombreUsuario")
    private String usuNombreUsuario;

    @Getter
    @Setter
    @Column(name = "usuContrasena")
    private String usuContrasena;

    @Getter
    @Setter
    @Column(name = "usuTokenPassword")
    private String usuTokenPassword;

    @Getter
    @Setter
    @Column(name = "usuEstado")
    private int usuEstado;

    @Getter
    @Setter
    @Column(name = "usuIdHuella")
    private int usuIdHuella;

    @Getter
    @Setter
    @Column(name = "usuFechaRegistro")
    private Timestamp usuFechaRegistro;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "usuPerId")
    private Persona usuPerId;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "rolId", referencedColumnName = "rolId")
    private Rol rolId;
}
