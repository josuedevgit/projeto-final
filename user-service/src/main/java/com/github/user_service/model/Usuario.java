package com.github.user_service.model;

import com.github.user_service.model.records.RequestUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;

    public Usuario(RequestUsuario requestUsuario){
        this.nome = requestUsuario.nome();
        this.idade = requestUsuario.idade();
    }
}
