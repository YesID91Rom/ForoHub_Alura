package com.alura.ForoHub.domain.topico.validaciones;


import com.alura.ForoHub.domain.topico.DatosCrearTopico;
import com.alura.ForoHub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrosDeDuplicados implements ValidadorTopico{
    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosCrearTopico datos){
        var titulo = datos.titulo();
        var mensaje = datos.mensaje();

        var registroDuplicado = topicoRepository.existsByTituloAndMensaje(titulo, mensaje);

        if(registroDuplicado){
            throw new ValidationException("Mensaje duplicado en este título");
        }
    }

}
