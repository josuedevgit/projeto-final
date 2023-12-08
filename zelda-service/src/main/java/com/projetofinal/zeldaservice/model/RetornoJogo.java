package com.projetofinal.zeldaservice.model;

import lombok.Data;

import java.util.List;

@Data
public class RetornoJogo {

    private boolean success;
    private int count;
    private List<Zelda> data;
}

