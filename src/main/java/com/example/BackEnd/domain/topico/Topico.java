package com.example.BackEnd.domain.topico;

import com.example.BackEnd.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @NotBlank(message = "Campo requerido!")
    private String curso;

    @NotBlank(message = "Campo requerido!")
    private String titulo;

    @NotBlank(message = "Campo requerido!")
    private String mensaje;

    private LocalDateTime fecha;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Topico(Usuario usuario, String curso, String titulo, String mensaje) {
        this.usuario = usuario;
        this.curso = curso;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
        this.status = Status.ABIERTO;
    }

    public void actualizaTopico(ActualizaTopico datos){
        if (datos.curso() != null){
            this.curso = datos.curso();
        }

        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }

        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }

        if (datos.status() != null){
            this.status = datos.status();
        }

        this.fecha = LocalDateTime.now();
    }
}
