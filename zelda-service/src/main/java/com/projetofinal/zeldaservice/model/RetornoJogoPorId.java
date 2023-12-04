package com.projetofinal.zeldaservice.model;

import com.projetofinal.zeldaservice.Zelda;
import lombok.Data;

@Data
public class RetornoJogoPorId {
    private boolean success;
    private Zelda data;
}
