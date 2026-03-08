package com.example.BackEnd.controller;

import com.example.BackEnd.domain.ValidacionException;
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
    public ResponseEntity<Page<ListaTopicos>> listar(@PageableDefault(page = 0, size = 10, sort = { "fecha" }) Pageable paginacion) {
        var page = repository.findAll(paginacion).map(ListaTopicos::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalle(@PathVariable Long id){
        var resultado = manipulaTopico.detalleTopico(id);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid RegistroTopico registroTopico, UriComponentsBuilder builder){
        var resultado = manipulaTopico.registrarTopico(registroTopico);
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid ActualizaTopico datos){
        var val = repository.findById(id);
        if (!val.isPresent()){
            throw new ValidacionException("Registro no encontrado o no existe!");
        }

        val.get().actualizaTopico(datos);

        return ResponseEntity.ok().body("Registro actualizado!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id){
        var resultado = repository.findById(id);
        if (!resultado.isPresent()){
            throw new ValidacionException("Registro no existe!");
        }
        repository.deleteById(id);

        return ResponseEntity.ok().body("Registro eliminado existosamente!");
    }


}
