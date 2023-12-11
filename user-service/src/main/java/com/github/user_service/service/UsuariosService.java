package com.github.user_service.service;
import com.github.user_service.model.Usuario;
import com.github.user_service.model.UsuarioJogosFavoritosDTO;
import com.github.user_service.model.Zelda;
import com.github.user_service.model.records.RequestUsuario;
import com.github.user_service.repository.UsuariosRepository;
import com.github.user_service.repository.ZeldaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UsuariosService {
    @Autowired
    private ZeldaRepository zeldaRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuario> listaUsuarios(){
        return usuariosRepository.findAll();
    }

    public Usuario addUsuario(Usuario usuario){
        return usuariosRepository.save(usuario);
    }

    public Usuario updateUsuario(RequestUsuario requestUsuario, Long id){
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNome(requestUsuario.nome());
            usuarioExistente.setIdade(requestUsuario.idade());

            return usuariosRepository.save(usuarioExistente);
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
    public Usuario obterUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);
        return usuarioOptional.orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    //// Métodos dos jogos favoritos
    public List<UsuarioJogosFavoritosDTO> listarUsuariosEJogosFavoritos() {
        List<Usuario> usuarios = usuariosRepository.findAll();
        List<UsuarioJogosFavoritosDTO> dtos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            List<Zelda> jogosFavoritos = usuario.getJogosFavoritos();
            UsuarioJogosFavoritosDTO dto = new UsuarioJogosFavoritosDTO();
            dto.setNome(usuario.getNome());
            dto.setJogosFavoritos(jogosFavoritos);
            dtos.add(dto);
        }

        return dtos;
    }
    public UsuarioJogosFavoritosDTO addJogoFavorito(Long idUsuario, String idZelda) {
        Optional<Usuario> optionalUsuario = usuariosRepository.findById(idUsuario);
        Optional<Zelda> optionalJogoFavorito = zeldaRepository.findById(idZelda);
        if (optionalUsuario.isPresent() && optionalJogoFavorito.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            Zelda jogoFavorito = optionalJogoFavorito.get();
            usuario.getJogosFavoritos().add(jogoFavorito);
            usuariosRepository.save(usuario);
            UsuarioJogosFavoritosDTO dto = new UsuarioJogosFavoritosDTO();
            dto.setNome(usuario.getNome());
            dto.setJogosFavoritos(usuario.getJogosFavoritos());
            return dto;
        } else {
            return null;
        }
    }

}


