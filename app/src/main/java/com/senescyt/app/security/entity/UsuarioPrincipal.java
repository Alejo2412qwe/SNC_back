package com.senescyt.app.security.entity;

import com.senescyt.app.model.Rol;
import com.senescyt.app.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class UsuarioPrincipal implements UserDetails {


    private String nombreUsuario;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombreUsuario, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.authorities = authorities;
    }
//    public static UsuarioPrincipal build(Usuario usuario){
//        List<GrantedAuthority> authorities =
//                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
//                        .getRolNombre().name())).collect(Collectors.toList());
//        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
//    }

    public static UsuarioPrincipal build(Usuario usuario) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        Rol rol = usuario.getRolId();

        if (rol != null) {
            authorities.add(new SimpleGrantedAuthority(rol.getRolNombre()));
        }

        return new UsuarioPrincipal(usuario.getUsuNombreUsuario(), usuario.getUsuContrasena(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
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

    @Override
    public boolean isEnabled() {
        return true;
    }

}
