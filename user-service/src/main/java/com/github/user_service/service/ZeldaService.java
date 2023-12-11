package com.github.user_service.service;

import com.github.user_service.model.Zelda;
import com.github.user_service.repository.ZeldaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZeldaService {

    @Autowired
    private ZeldaRepository zeldaRepository;

    public Zelda obterJogoZeldaPorId(String id) {
        Optional<Zelda> zeldaOptional = zeldaRepository.findById(id);
        return zeldaOptional.orElseThrow(() -> new RuntimeException("Jogo Zelda não encontrado"));
    }
}
