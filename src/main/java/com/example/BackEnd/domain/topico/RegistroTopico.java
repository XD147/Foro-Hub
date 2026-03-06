package com.example.BackEnd.domain.topico;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistroTopico(
        @NotNull
        Long usuario_id,
        @NotNull
        String curso,
        @NotNull
        String titulo,
        @NotNull
        String mensaje
) {
}
