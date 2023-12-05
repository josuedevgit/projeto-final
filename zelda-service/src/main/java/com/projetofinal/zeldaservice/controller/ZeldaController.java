package com.projetofinal.zeldaservice.controller;

import com.projetofinal.zeldaservice.model.ZeldaDTO;
import com.projetofinal.zeldaservice.service.ZeldaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zelda")
public class ZeldaController {

    @Autowired
    private ZeldaService zeldaService;

    @GetMapping
    public List<ZeldaDTO> getAllZeldas() {
       List<ZeldaDTO> response = zeldaService.getAllZeldas();
       return response;
    }

    @GetMapping("/zelda/{id}")
    public ZeldaDTO getZeldaById(@PathVariable String id) {
        return zeldaService.getZeldaById(id);
    }

}
