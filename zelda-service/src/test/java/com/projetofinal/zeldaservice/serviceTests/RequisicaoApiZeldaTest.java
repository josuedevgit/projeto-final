package com.projetofinal.zeldaservice.serviceTests;


import com.projetofinal.zeldaservice.service.RequisicaoApiZeldaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;


public class RequisicaoApiZeldaTest {

    private RequisicaoApiZeldaService zeldaService;
    private WebClient.Builder webClientBuilder;
    @Value("${api.zelda.url}")
    private String apiZeldaUrl;


    @Test
    void testGetAll() {

    }
}
