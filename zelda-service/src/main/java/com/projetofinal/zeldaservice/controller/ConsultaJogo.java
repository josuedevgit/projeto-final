package com.projetofinal.zeldaservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("busca-jogo")
public class ConsultaJogo {

    @GetMapping("{id}")
    public ZeldaResultDTO consultaJogo(@PathVariable("id") long id){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<ZeldaResultDTO> resp = rt.getForEntity("https://zelda.fanapis.com/api/games", ZeldaResultDTO.class);

        return resp.getBody();
    }
}
