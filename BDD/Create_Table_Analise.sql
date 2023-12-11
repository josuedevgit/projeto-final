CREATE TABLE analise (
    id SERIAL PRIMARY KEY,
    review VARCHAR(3000),
    id_usuario INTEGER REFERENCES usuarios(id) ON DELETE CASCADE,
    id_zelda VARCHAR(55) REFERENCES zelda(id) ON DELETE CASCADE,
    CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    CONSTRAINT fk_id_zelda FOREIGN KEY (id_zelda) REFERENCES zelda(id)
);
