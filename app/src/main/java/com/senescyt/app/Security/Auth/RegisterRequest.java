package com.senescyt.app.Security.Auth;

import com.senescyt.app.model.*;
import jakarta.persistence.Column;
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
    private Long usuId;
    private String usuNombreUsuario;
    private String usuContrasena;
    private String usuCorreo;
    private int usuEstado;
    private Timestamp usuFechaRegistro;
    private Persona usuPerId;
    private Rol rolId;
    private Funciones funId;
    private Institucion insId;
    private Procesos procId;
    private Regimen regId;
    private Zonales zonId;
    private Horarios horId;
    private Long usuIdLector;
    private Long usuIdJefe;

}
