package com.aluracursos.forohub.posts;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PostRecord(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje) {
}
