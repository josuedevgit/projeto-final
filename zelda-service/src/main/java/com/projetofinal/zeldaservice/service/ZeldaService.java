package com.projetofinal.zeldaservice.service;

import com.projetofinal.zeldaservice.model.Zelda;
import com.projetofinal.zeldaservice.model.RetornoJogo;
import com.projetofinal.zeldaservice.model.RetornoJogoPorId;
import com.projetofinal.zeldaservice.model.ZeldaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZeldaService {

    @Autowired
    private RequisicaoApiZeldaService requisicaoApiZeldaService;

    public List<ZeldaDTO> getAllZeldas() {
        RetornoJogo response = requisicaoApiZeldaService.getAll();

        List<ZeldaDTO> dtos = response.getData().stream()
                .map(this::mappingZeldaToDTO)
                .collect(Collectors.toList());

        return dtos;
    }

    public ZeldaDTO getZeldaById(String id) {
        RetornoJogoPorId response = requisicaoApiZeldaService.getZeldaById(id);

        Zelda zelda = response.getData();
        ZeldaDTO dto = mappingZeldaToDTO(zelda);
        return dto;

    }

    private ZeldaDTO mappingZeldaToDTO(Zelda zelda) {
        ZeldaDTO dto = ZeldaDTO.builder()

                .nome(zelda.getName())
                .descricao(zelda.getDescription())
                .dataLancamento(zelda.getReleased_date())
                .publicante(zelda.getPublisher())
                .desenvolvedor(zelda.getDeveloper())
                .id(zelda.getId())
                .build();
        return dto;
    }
}
