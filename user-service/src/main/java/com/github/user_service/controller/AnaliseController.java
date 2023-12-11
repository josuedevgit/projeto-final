package com.github.user_service.controller;
import com.github.user_service.model.Analise;
import com.github.user_service.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/analises")
public class AnaliseController {

    @Autowired
    private AnaliseService analiseService;

    @GetMapping
    public ResponseEntity<List<Analise>> listarAnalises() {
        List<Analise> analises = analiseService.listaAnalises();
        return ResponseEntity.status(HttpStatus.OK).body(analises);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Analise> obterAnalisePorId(@PathVariable Long idAnalise) {
        Analise analise = analiseService.obterAnalisePorId(idAnalise);
        return ResponseEntity.status(HttpStatus.OK).body(analise);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Analise> adicionarAnalise(@RequestParam Long idUsuario, @RequestParam String idZelda, @RequestParam String reviewAnalise) {
        Analise analise = analiseService.adicionarAnalise(idUsuario, idZelda, reviewAnalise);
        return ResponseEntity.status(HttpStatus.CREATED).body(analise);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Analise> atualizarAnalise(@PathVariable Long idAnalise, @RequestParam String reviewAnalise) {
        Analise analiseAtualizada = analiseService.atualizarAnalise(idAnalise, reviewAnalise);
        return ResponseEntity.status(HttpStatus.OK).body(analiseAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Long idAnalise) {
        analiseService.deletarAnalise(idAnalise);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
