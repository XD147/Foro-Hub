package com.example.BackEnd.domain.topico;

import com.example.BackEnd.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Campo requerido!")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @NotBlank(message = "Campo requerido!")
    private String curso;

    @NotBlank(message = "Campo requerido!")
    private String titulo;

    @NotBlank(message = "Campo requerido!")
    private String mensaje;

    @NotBlank(message = "Campo requerido!")
    private LocalDateTime fecha;

    @NotBlank(message = "Campo requerido!")
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

    public void actualizaStatus(Status statusUpdate){
        this.status = statusUpdate;
    }
}
