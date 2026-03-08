package com.example.BackEnd.domain.topico;

public record ActualizaTopico(
        String curso,
        String titulo,
        String mensaje,
        Status status

) {
    public ActualizaTopico(Topico datos) {
        this(datos.getCurso(), datos.getTitulo(), datos.getMensaje(), datos.getStatus());
    }
}
