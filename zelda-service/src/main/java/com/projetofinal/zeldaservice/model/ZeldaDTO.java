package com.projetofinal.zeldaservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZeldaDTO {

    private String id;
    private String nome;
    private String descricao;
    private String desenvolvedor;
    private String publicante;
    private String dataLancamento;


}
