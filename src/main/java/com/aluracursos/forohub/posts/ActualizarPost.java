package com.aluracursos.forohub.posts;

import jakarta.validation.constraints.NotNull;

public record ActualizarPost(@NotNull Long id, String titulo, String mensaje) {
}
