package com.projetofinal.zeldaservice.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JogoZelda {
    private String nome;
    private String descricao;
    private String publicante;
    private String dataLancamento;
    private long id;
}
