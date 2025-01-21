package com.alura.ForoHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        String login,
        String clave
) {
}