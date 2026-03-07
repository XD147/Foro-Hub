package com.example.BackEnd.domain.topico;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistroTopico(
        @NotBlank
        Long usuario_id,
        @NotBlank
        String curso,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje
) {
}
