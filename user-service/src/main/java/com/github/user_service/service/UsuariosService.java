package com.github.user_service.service;
import com.github.user_service.model.Usuario;
import com.github.user_service.model.records.RequestUsuario;
import com.github.user_service.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

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
}
