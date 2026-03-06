package com.example.BackEnd.controller;

import com.example.BackEnd.domain.topico.ListaTopicos;
import com.example.BackEnd.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<ListaTopicos>> listar(@PageableDefault(page = 0, size = 10, sort = { "curso" }) Pageable paginacion) {
        var page = repository.findAll(paginacion).map(ListaTopicos::new);

        return ResponseEntity.ok(page);
    }

}
