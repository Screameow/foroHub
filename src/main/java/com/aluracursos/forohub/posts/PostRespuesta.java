package com.aluracursos.forohub.posts;

import java.time.LocalDateTime;

public record PostRespuesta(Long id, String titulo, String mensaje, LocalDateTime fechaDeCreacion) {
}
