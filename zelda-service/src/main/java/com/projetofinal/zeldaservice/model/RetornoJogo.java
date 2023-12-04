package com.projetofinal.zeldaservice.model;

import com.projetofinal.zeldaservice.Zelda;
import lombok.Data;

import java.util.List;

@Data
public class RetornoJogo {

    private boolean success;
    private int count;
    private List<Zelda> data;
}

