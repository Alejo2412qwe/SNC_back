package com.senescyt.app.security2.service;

import com.senescyt.app.model.Usuario;
import com.senescyt.app.security2.entity.UsuarioPrincipal;
import com.senescyt.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= service.getByUsuNombreUsuario(username).get();
        return UsuarioPrincipal.build(usuario);
    }
}
