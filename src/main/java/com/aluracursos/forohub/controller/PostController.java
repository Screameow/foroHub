package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.posts.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<PostRespuesta> registrarPost(@RequestBody @Valid PostRecord postRecord, UriComponentsBuilder uriComponentsBuilder){
        Post post = postRepository.save(new Post(postRecord));
        PostRespuesta postRespuesta = new PostRespuesta(post.getId(), post.getTitulo(), post.getMensaje(), post.getFechaDeCreacion());

        URI url = uriComponentsBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(url).body(postRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<ListadoPost>> obtenerPost(@PageableDefault Pageable paginacion) {
        Page<Post> posts = postRepository.findAll(paginacion);
        Page<ListadoPost> listadoPosts = posts.map(ListadoPost::new);
        return ResponseEntity.ok(listadoPosts);
    }

    @PutMapping
    public ResponseEntity actualizarPost(@RequestBody @Valid ActualizarPost actualizarPost) {
        Post post = postRepository.getReferenceById(actualizarPost.id());
        post.actualizarPost(actualizarPost);
        return ResponseEntity.ok(new PostRespuesta(post.getId(), post.getTitulo(), post.getMensaje(), post.getFechaDeCreacion()));
    }






}
