package com.example.BackEnd.domain.topico;

import com.example.BackEnd.domain.ValidacionException;
import com.example.BackEnd.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ManipulaTopico {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DetalleTopico registrarTopico(RegistroTopico datos){

        if (!usuarioRepository.existsById(datos.usuario_id())){
            throw new ValidacionException("No existe el usuario indicado");
        }
        var usr = usuarioRepository.findById(datos.usuario_id());

        var nuevoTopico = new Topico(usr.get(), datos.curso(), datos.titulo(), datos.mensaje(), LocalDateTime.now(), Status.ABIERTO);

        topicoRepository.save(nuevoTopico);

        return new DetalleTopico(nuevoTopico);
    }
}
