package com.projetofinal.zeldaservice;

import lombok.Data;


@Data
public class Zelda {
    private String nome;
    private String descricao;
    private String desenvolvedor;
    private String publicante;
    private String dataLancamento;
    private long id;
}
