package com.alura.ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico (
        Long id,
        String titulo,
        String mensaje,
        Estado status,
        String autorx,
        String nombreCurso,
        LocalDateTime fecha){
    public DatosListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getStatus(),topico.getUsuario().getUsername(),topico.getNombreCurso(),topico.getFecha());
    }
}
