package com.example.BackEnd.domain.topico;

import java.time.LocalDateTime;

public record ListaTopicos(Long id, String usuario, String curso, String titulo, String mensaje, LocalDateTime fecha) {

    public ListaTopicos(Topico topico) {
        this(topico.getId(), topico.getUsuario().getLogin(), topico.getCurso(), topico.getTitulo(), topico.getMensaje(), topico.getFecha());
    }
}
