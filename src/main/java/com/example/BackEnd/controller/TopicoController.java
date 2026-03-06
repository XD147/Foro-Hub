package com.example.BackEnd.controller;

import com.example.BackEnd.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private ManipulaTopico manipulaTopico;

    @GetMapping
    public ResponseEntity<Page<ListaTopicos>> listar(@PageableDefault(page = 0, size = 10, sort = { "curso" }) Pageable paginacion) {
        var page = repository.findAll(paginacion).map(ListaTopicos::new);

        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid RegistroTopico registroTopico, UriComponentsBuilder builder){
        var resultado = manipulaTopico.registrarTopico(registroTopico);
        return ResponseEntity.ok(resultado);
    }

}
