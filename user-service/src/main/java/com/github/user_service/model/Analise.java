package com.github.user_service.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "analise")
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review", nullable = false, length = 3000)
    private String review;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_zelda", nullable = false)
    private Zelda jogoFavorito;

    public Analise(String review, Usuario usuario, Zelda jogoZelda) {
        this.review = review;
        this.usuario = usuario;
        this.jogoFavorito = jogoZelda;
    }
}
