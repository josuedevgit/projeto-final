package com.github.user_service.controller;
import com.github.user_service.model.Zelda;
import com.github.user_service.model.Usuario;
import com.github.user_service.model.UsuarioJogosFavoritosDTO;
import com.github.user_service.model.records.RequestUsuario;
import com.github.user_service.repository.UsuariosRepository;
import com.github.user_service.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class
UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public ResponseEntity listarUsuarios() {
        List<Usuario> usuarios = usuariosService.listaUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/{id}/jogosFavoritos")
    public ResponseEntity<?> getJogosFavoritos(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioOptional.get();

        List<Zelda> jogosFavoritos = usuario.getJogosFavoritos();

        UsuarioJogosFavoritosDTO dto = new UsuarioJogosFavoritosDTO();
        dto.setNome(usuario.getNome());
        dto.setJogosFavoritos(jogosFavoritos);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/add")
    public ResponseEntity adicionarUsuario(@Valid @RequestBody RequestUsuario requestUsuario){
        try {
            Usuario usuario = new Usuario(requestUsuario);
            Usuario usuarioCadastrado = usuariosService.addUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id,  @RequestBody @Valid RequestUsuario requestUsuario) {
        Usuario usuarioAtualizado = usuariosService.updateUsuario(requestUsuario, id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário " + usuarioAtualizado.getNome() + " atualizado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        Usuario usuarioDeletado = usuariosService.deleteUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }

}
