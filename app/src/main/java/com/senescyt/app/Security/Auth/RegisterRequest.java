package com.senescyt.app.Security.Auth;

import com.senescyt.app.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String usuNombreUsuario;
    String usuContrasena;
    String usuCorreo;
    Rol rol;
}
