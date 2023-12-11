package com.github.user_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "zelda")
public class Zelda {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private String desenvolvedor;
    private String publicante;
    @Column(name = "datalancamento")
    private Date dataLancamento;
}
