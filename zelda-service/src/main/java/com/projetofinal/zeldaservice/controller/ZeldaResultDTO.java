package com.projetofinal.zeldaservice.controller;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ZeldaResultDTO {
    private String nome;
    private String descricao;
    private String publicante;
    private String dataLancamento;
    private long id;
}
