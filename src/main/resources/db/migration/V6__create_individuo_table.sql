CREATE TABLE individuo (
    id_individuo INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    id_psicologo INTEGER NOT NULL,

    CONSTRAINT fk_individuo_psicologo
        FOREIGN KEY (id_psicologo)
        REFERENCES usuario (id_usuario)
        ON DELETE CASCADE
);
