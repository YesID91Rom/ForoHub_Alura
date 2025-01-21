package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.usuario.DatosRegistroUsuario;
import com.alura.ForoHub.domain.usuario.Usuario;
import com.alura.ForoHub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        // Crear usuario a partir del DTO
        Usuario usuario = new Usuario();
        usuario.setEmail(datosRegistroUsuario.email());
        usuario.setClave(passwordEncoder.encode(datosRegistroUsuario.clave()));

        // Guardar en la base de datos
        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}