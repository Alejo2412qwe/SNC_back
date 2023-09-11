package com.senescyt.app.emailRecover.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CambiarContra {

    @NotBlank
    private String password;
    @NotBlank
    private String passwordr;
    @NotBlank
    private String token;
}
