package com.alura.ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado status,
        String autor,
        String nombreCurso,
        LocalDateTime fecha
) {
}