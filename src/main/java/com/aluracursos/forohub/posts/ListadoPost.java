package com.aluracursos.forohub.posts;

import java.time.LocalDateTime;

public record ListadoPost(Long id, String titulo, String mensaje, LocalDateTime fechaDeCreacion) {

    public ListadoPost (Post post){
        this(post.getId(), post.getTitulo(), post.getMensaje(), post.getFechaDeCreacion());
    }

}
