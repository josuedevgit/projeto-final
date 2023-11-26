package com.github.user_service.service;
import com.github.user_service.model.Usuario;
import com.github.user_service.model.records.RequestUsuario;
import com.github.user_service.repository.UsuariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuario> listaUsuarios(){
        List<Usuario> usuarios = usuariosRepository.findAll();
        return usuarios;
    }

    public Usuario addUsuario(Usuario usuario){
        usuariosRepository.save(usuario);
        return usuario;
    }

    public Usuario updateUsuario(RequestUsuario requestUsuario, Long id){
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();

            usuarioExistente.setNome(requestUsuario.nome());
            usuarioExistente.setIdade(requestUsuario.idade());

            usuariosRepository.save(usuarioExistente);
            return usuarioExistente;
        } else {
            throw new RuntimeException("Usuário inexistente!");
        }
    }

    public Usuario deleteUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);

        if(usuarioOptional.isPresent()) {
            Usuario usuarioDeletado = usuarioOptional.get();
            usuariosRepository.delete(usuarioDeletado);
            return usuarioDeletado;
        } else {
            throw new RuntimeException("Usuário inexistente!");
        }
    }

}
