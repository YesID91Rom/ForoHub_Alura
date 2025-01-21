package com.alura.ForoHub.domain.topico;

import com.alura.ForoHub.domain.topico.validaciones.ValidadorTopico;
import com.alura.ForoHub.domain.usuario.UsuarioRepository;
import com.alura.ForoHub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    List<ValidadorTopico> validadores;

    public DatosDetalleTopico crear(DatosCrearTopico datos){
        if(datos.idUsuario()!=null&&!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionDeIntegridad("Id de usuario no encontrado");
        }
        validadores.forEach(v->v.validar(datos));
        var usuario = usuarioRepository.findById(datos.idUsuario()).get();
        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                usuario,
                datos.nombreCurso()
        );
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }


}
