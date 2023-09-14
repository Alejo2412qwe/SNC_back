package com.senescyt.app.Security.Auth;

import com.senescyt.app.Security.Jwt.JwtService;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {

        return null;
    }

    public AuthResponse register(RegisterRequest request) {

        Usuario user = Usuario.builder()
                .usuContrasena(request.getUsuContrasena())
                .usuContrasena(request.getUsuContrasena())
                .usuCorreo(request.getUsuCorreo())
                .rolId(request.rol)
                .build();

        repository.save(user);
        return AuthResponse.builder()
                .token(null)
                .token(jwtService.getToken(user))
                .build();
    }
}
