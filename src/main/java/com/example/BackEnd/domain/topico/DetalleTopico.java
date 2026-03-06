package com.example.BackEnd.domain.topico;

import com.example.BackEnd.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public record DetalleTopico(
        Long id,
        String usuario,
        String curso,
        String titulo,
        String mensaje,
        String fecha,
        Status status
) {
    public DetalleTopico(Topico datos) {
        this(datos.getId(), datos.getUsuario().getLogin(), datos.getCurso(), datos.getTitulo(), datos.getMensaje(), datos.getFecha().toString(), datos.getStatus());
    }
}
