package com.aluracursos.forohub.posts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Table(name = "posts")
@Entity(name = "Post")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name = "fecha")
    private LocalDateTime fechaDeCreacion;

public Post (PostRecord postRecord){
    this.titulo = postRecord.titulo();
    this.mensaje = postRecord.mensaje();
    this.fechaDeCreacion = LocalDateTime.now();
}

public void actualizarPost(ActualizarPost actualizarPost){
    if (actualizarPost.titulo() != null){
        this.titulo = actualizarPost.titulo();
    }

    if (actualizarPost.mensaje() != null) {
        this.mensaje = actualizarPost.mensaje();
    }
}

}
