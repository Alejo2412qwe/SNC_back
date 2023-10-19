package com.senescyt.app.Security.Auth;

import com.senescyt.app.Security.Jwt.JwtService;
import com.senescyt.app.model.Usuario;
import com.senescyt.app.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuNombreUsuario(), request.getUsuContrasena()));
        UserDetails user=userRepository.findByUsuNombreUsuario(request.getUsuNombreUsuario()).orElseThrow();
//        System.out.println("PASSS = "+userRepository.findByUsuNombreUsuario(request.getUsuNombreUsuario()));

        String token=jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        System.out.println(request.toString()+"\n\n\n\n\n\n");
        Usuario user = Usuario.builder()
                .usuNombreUsuario(request.getUsuNombreUsuario())
                .usuContrasena(passwordEncoder.encode( request.getUsuContrasena()))
                .usuCorreo(request.getUsuCorreo())
                .usuEstado(request.getUsuEstado())
                .usuFechaRegistro(request.getUsuFechaRegistro())
                .usuPerId(request.getUsuPerId())
                .rolId(request.getRolId())
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

    public boolean usuarioValido(String user) {
        int cont = userRepository.usuarioUnico(user.trim());

        if (cont > 0) {
            return true;
        } else {
            return false;
        }
    }
}
