package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.usuarios.DatosAutenticacionUsuario;
import com.aluracursos.forohub.infra.security.DatosJWTToken;
import com.aluracursos.forohub.infra.security.TokenService;
import com.aluracursos.forohub.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        System.out.println("Intentando autenticar usuario: " + datosAutenticacionUsuario.login());
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        try {
            var usuarioAutenticado = authenticationManager.authenticate(authToken);
            var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            System.out.println("Autenticación exitosa para usuario: " + datosAutenticacionUsuario.login());
            return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
        } catch (Exception e) {
            System.out.println("Error de autenticación para usuario: " + datosAutenticacionUsuario.login() + " - " + e.getMessage());
            throw e;
        }
    }
}


