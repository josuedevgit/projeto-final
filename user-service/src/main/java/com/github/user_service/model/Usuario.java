package com.github.user_service.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.user_service.model.records.RequestUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "jogofavorito",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "zelda_id")
    )
    private List<Zelda> jogosFavoritos;

    public Usuario(RequestUsuario requestUsuario){
        this.nome = requestUsuario.nome();
        this.idade = requestUsuario.idade();
    }
}
