package com.example.BackEnd.domain.topico;

import com.example.BackEnd.domain.usuario.Usuario;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String curso;

    private String titulo;

    private String mensaje;

    private LocalDateTime fecha;

    @Column(name = "status_topico")
    @Enumerated(EnumType.STRING)
    private Status status;

    public void actualizaStatus(Status statusUpdate){
        this.status = statusUpdate;
    }
}
