/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import lombok.*;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author ALEJO PC
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usuario")
public class Usuario implements UserDetails {

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
    @Column(name = "usuCorreo")
    private String usuCorreo;

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

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rolId.getRolNombre()));
    }

    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return null;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
