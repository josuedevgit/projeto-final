package com.github.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioJogosFavoritosDTO {

    private String nome;
    private List<Zelda> jogosFavoritos;
}
