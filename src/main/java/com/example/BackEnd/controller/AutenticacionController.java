package com.example.BackEnd.controller;

import com.example.BackEnd.domain.usuario.DatosAutentificacion;
import com.example.BackEnd.domain.usuario.Usuario;
import com.example.BackEnd.infra.security.DatosTokenJWT;
import com.example.BackEnd.infra.security.TokenService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutentificacion datos){
        var authenticationtoken = new UsernamePasswordAuthenticationToken(datos.login(), datos.password());
        var autentificacion = manager.authenticate(authenticationtoken);

        var tokenJWT = tokenService.generarToken((Usuario) autentificacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}
