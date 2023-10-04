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
import java.util.Collection;
import java.util.List;

import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ALEJO PC
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {

    /**
     *
     */
    // private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuId")
    private Long usuId;

    @Basic
    @Column(nullable = false)
    private String usuNombreUsuario;

    @Basic
    @Column(nullable = false)
    private String usuContrasena;

    @Column(name = "usuCorreo")
    private String usuCorreo;

    @Column(name = "usuTokenPassword")
    private String usuTokenPassword;

    @Column(name = "usuEstado")
    private int usuEstado;

    @Column(name = "usuFechaRegistro")
    private Timestamp usuFechaRegistro;

    @OneToOne
    @JoinColumn(name = "usuPerId")
    private Persona usuPerId;

    @ManyToOne
    @JoinColumn(name = "rolId", referencedColumnName = "rolId")
    private Rol rolId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rolId.getRolNombre())));
    }

    @ManyToOne
    @JoinColumn(name = "funId", referencedColumnName = "funId")
    private Funciones funId;

    @ManyToOne
    @JoinColumn(name = "insId", referencedColumnName = "insId")
    private Institucion insId;

    @Override
    public String getPassword() {
        return this.getUsuContrasena();
    }

    @Override
    public String getUsername() {
        return this.usuNombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "usuId")
    private List<Permisos> listaPermisos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuId")
    private List<Vacaciones> listaVacaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "usuId", cascade = CascadeType.ALL)
    private List<Asistencia> listaAsistencia;

    @Override
    public boolean isEnabled() {
        return true;
    }
}
