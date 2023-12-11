package com.github.user_service.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jogofavorito")
public class JogoFavorito {

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "zelda_id", nullable = false)
    private Zelda jogoFavorito;

    public JogoFavorito(Usuario usuario, Zelda jogoFavorito) {
        this.usuario = usuario;
        this.jogoFavorito = jogoFavorito;
    }
}