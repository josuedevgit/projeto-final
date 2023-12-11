package com.github.user_service.service;
import com.github.user_service.model.*;
import com.github.user_service.repository.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnaliseService {

    @Autowired
    private AnaliseRepository analiseRepository;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private ZeldaService zeldaService;

    public List<Analise> listaAnalises() {
        return analiseRepository.findAll();
    }

    public Analise adicionarAnalise(Long idUsuario, String idZelda, String reviewAnalise) {
        Usuario usuario = usuariosService.obterUsuarioPorId(idUsuario);
        Zelda jogoZelda = zeldaService.obterJogoZeldaPorId(idZelda);

        Analise analise = new Analise(reviewAnalise, usuario, jogoZelda);
        analiseRepository.save(analise);

        return analise;
    }

    public Analise obterAnalisePorId(Long idAnalise) {
        Optional<Analise> analiseOptional = analiseRepository.findById(idAnalise);
        return analiseOptional.orElseThrow(() -> new RuntimeException("Análise não encontrada"));
    }

    public Analise atualizarAnalise(Long idAnalise, String reviewAnalise) {
        Optional<Analise> analiseOptional = analiseRepository.findById(idAnalise);

        if (analiseOptional.isPresent()) {
            Analise analiseExistente = analiseOptional.get();
            analiseExistente.setReview(reviewAnalise);

            analiseRepository.save(analiseExistente);
            return analiseExistente;
        } else {
            throw new RuntimeException("Análise inexistente!");
        }
    }

    public void deletarAnalise(Long idAnalise) {
        Optional<Analise> analiseOptional = analiseRepository.findById(idAnalise);

        if (analiseOptional.isPresent()) {
            Analise analiseDeletada = analiseOptional.get();
            analiseRepository.delete(analiseDeletada);
        } else {
            throw new RuntimeException("Análise inexistente!");
        }
    }
}
