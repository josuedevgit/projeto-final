package com.projetofinal.zeldaservice.service;

import com.projetofinal.zeldaservice.model.JogoZelda;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ZeldaApiService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "https://zelda.fanapis.com/api/games";
    private final String gameId = "https://zelda.fanapis.com/api/games/:game_id";

    public JogoZelda [] getJogos(String limit, String page, String name) {
        Map<String, String> params = new HashMap<>();
        params.put("limit", limit);
        params.put("page", page);
        params.put("name", name);

        String urlComParametros = apiUrl + "?limit={limit}&page={page}&name={name}";
        return restTemplate.getForObject(urlComParametros, JogoZelda[].class, params);
        }
    }

