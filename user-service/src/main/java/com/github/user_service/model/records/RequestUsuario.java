package com.github.user_service.model.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


public record RequestUsuario(@NotBlank(message = "O campo 'nome' não pode estar vazio.") String nome, @NotNull(message = "O campo 'idade' não pode estar vazio.") int idade) {
    @Override

    public String nome() {
        return nome;
    }

    @Override
    public int idade() {
        return idade;
    }
}
