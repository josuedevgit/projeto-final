package com.projetofinal.zeldaservice.service;

import com.projetofinal.zeldaservice.model.RetornoJogo;
import com.projetofinal.zeldaservice.model.RetornoJogoPorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RequisicaoApiZeldaService {

    @Value("${api.zelda.url}")
    private String apiZeldaUrl;

    @Autowired
    private WebClient.Builder builder;

    public RetornoJogo getAll() {

        RetornoJogo response = builder.build()
                .get()
                .uri(apiZeldaUrl)
                .retrieve()
                .bodyToMono(RetornoJogo.class)
                .block();

        return response;
    }

    public RetornoJogoPorId getZeldaById(String id) {
        String apiUrlComId = apiZeldaUrl +  "/" + id;

        RetornoJogoPorId response = builder.build()
                .get()
                .uri(apiUrlComId)
                .retrieve()
                .bodyToMono(RetornoJogoPorId.class)
                .block();

        return response;


    }
}
