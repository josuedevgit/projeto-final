package com.github.user_service.controller;
import com.github.user_service.model.Analise;
import com.github.user_service.model.Zelda;
import com.github.user_service.model.Usuario;
import com.github.user_service.model.UsuarioJogosFavoritosDTO;
import com.github.user_service.model.records.RequestUsuario;
import com.github.user_service.repository.UsuariosRepository;
import com.github.user_service.service.AnaliseService;
import com.github.user_service.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/usuarios")
public class
UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private AnaliseService analiseService;


    @GetMapping
    public ResponseEntity listarUsuarios() {
        List<Usuario> usuarios = usuariosService.listaUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }
    @GetMapping("usuarios/{id}")
    public ResponseEntity<?> obterUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuariosService.obterUsuarioPorId(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
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
    ///////////////////////////////////////// ENDPOINTS DOS JOGOS FAVORITOS /////////////////////////////////
    @GetMapping("/jogosfavoritos")
    public ResponseEntity<List<UsuarioJogosFavoritosDTO>> listarUsuariosEJogosFavoritos() {
        List<UsuarioJogosFavoritosDTO> dtos = usuariosService.listarUsuariosEJogosFavoritos();
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}/jogosfavoritos")
    public ResponseEntity<?> getJogosFavoritos(@PathVariable Long id) {
        Usuario usuario = usuariosService.obterUsuarioPorId(id);

        if (usuario != null) {
            List<Zelda> jogosFavoritos = usuario.getJogosFavoritos();

            UsuarioJogosFavoritosDTO dto = new UsuarioJogosFavoritosDTO();
            dto.setNome(usuario.getNome());
            dto.setJogosFavoritos(jogosFavoritos);

            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idUsuario}/addjogosfavoritos/{idZelda}")
    public ResponseEntity<?> addJogoFavorito(@PathVariable Long idUsuario, @PathVariable String idZelda) {
        UsuarioJogosFavoritosDTO dto = usuariosService.addJogoFavorito(idUsuario, idZelda);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ///////////////////////////////////////// ENDPOINTS DAS ANÁLISES /////////////////////////////////

    @GetMapping("/analises")
    public ResponseEntity<List<Analise>> listarAnalises() {
        List<Analise> analises = analiseService.listaAnalises();
        return ResponseEntity.status(HttpStatus.OK).body(analises);
    }

    @GetMapping("/analises/{idAnalise}")
    public ResponseEntity<Analise> obterAnalisePorId(@PathVariable Long idAnalise) {
        Analise analise = analiseService.obterAnalisePorId(idAnalise);
        return ResponseEntity.status(HttpStatus.OK).body(analise);
    }

    @PostMapping("/analises/adicionar")
    public ResponseEntity<Analise> adicionarAnalise(@RequestBody Map<String, String> requestBody) {
        Long idUsuario = Long.parseLong(requestBody.get("idUsuario"));
        String idZelda = requestBody.get("idZelda");
        String reviewAnalise = requestBody.get("reviewAnalise");

        Analise analise = analiseService.adicionarAnalise(idUsuario, idZelda, reviewAnalise);
        return ResponseEntity.status(HttpStatus.CREATED).body(analise);
    }

    @PutMapping("/analises/atualizar/{idAnalise}")
    public ResponseEntity<Analise> atualizarAnalise(@PathVariable Long idAnalise, @RequestBody Map<String, String> requestBody) {
        String reviewAnalise = requestBody.get("reviewAnalise");
        Analise analise = analiseService.atualizarAnalise(idAnalise, reviewAnalise);
        return ResponseEntity.status(HttpStatus.OK).body(analise);
    }

    @DeleteMapping("/analises/deletar/{idAnalise}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Long idAnalise) {
        analiseService.deletarAnalise(idAnalise);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
