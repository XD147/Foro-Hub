package com.example.BackEnd.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestionDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionError404(){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionError400(MethodArgumentNotValidException ex){
        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream().map(DatosValidacionError::new).toList());
    }

    public record DatosValidacionError(String campo, String mensaje){
        public DatosValidacionError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }



}
