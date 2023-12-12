package com.projetofinal.zeldaservice.serviceTests;


import com.projetofinal.zeldaservice.model.RetornoJogo;
import com.projetofinal.zeldaservice.service.RequisicaoApiZeldaService;
import com.projetofinal.zeldaservice.service.ZeldaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;


public class RequisicaoApiZeldaTest {

    private RequisicaoApiZeldaService zeldaService;
    private WebClient.Builder webClientBuilder;
    @Value("${api.zelda.url}")
    private String apiZeldaUrl;


    @Test
    void testGetAll() {

        //        WebClient webClient = mock(WebClient.class);

        //          RetornoJogo retornoJogoEsperado = new RetornoJogo();
        //          retornoJogoEsperado.setSuccess(true);

        //       when(webClient.get()
        //      .uri("https://zelda.fanapis.com/api/games")
        //      .retrieve()
        //           .bodyToMono(RetornoJogo.class))
        //           .thenReturn(Mono.just(retornoJogoEsperado));

        //      RetornoJogo resultado = zeldaService.getAll();

        //   Assertions.assertEquals(retornoJogoEsperado, resultado);

    }
}
