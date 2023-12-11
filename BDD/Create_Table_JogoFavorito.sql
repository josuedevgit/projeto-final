CREATE TABLE JogoFavorito (
    usuario_id INTEGER REFERENCES usuarios(id),
    zelda_id VARCHAR(55) REFERENCES zelda(id),
    PRIMARY KEY (usuario_id, zelda_id)
);