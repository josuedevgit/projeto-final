package com.projetofinal.zeldaservice.model;

import lombok.Data;

@Data
public class RetornoJogoPorId {
    private boolean success;
    private Zelda data;
}
