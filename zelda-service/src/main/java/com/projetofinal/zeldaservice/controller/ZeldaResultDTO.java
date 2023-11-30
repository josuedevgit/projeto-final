package com.projetofinal.zeldaservice.controller;

import lombok.Data;

@Data
public class ZeldaResultDTO {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
    private long id;
}
