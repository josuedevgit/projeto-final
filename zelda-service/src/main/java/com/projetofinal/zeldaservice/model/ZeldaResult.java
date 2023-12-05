package com.projetofinal.zeldaservice.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ZeldaResult {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private UUID id;
}
