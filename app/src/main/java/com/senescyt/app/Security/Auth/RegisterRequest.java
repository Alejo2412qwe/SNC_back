package com.senescyt.app.Security.Auth;

import com.senescyt.app.model.Persona;
import com.senescyt.app.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String usuNombreUsuario;
    private String usuContrasena;
    private String usuCorreo;
    private int usuEstado;
    private Timestamp usuFechaRegistro;
    private Persona usuPerId;
    private Rol rolId;
}
