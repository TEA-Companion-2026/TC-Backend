CREATE TABLE rotina (
    id_rotina INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT NOT NULL,
    descricao TEXT,
    dia_semana TEXT NOT NULL,
    horario TEXT NOT NULL,
    id_individuo INTEGER NOT NULL,
    
    CONSTRAINT fk_rotina_individuo 
        FOREIGN KEY (id_individuo) 
        REFERENCES usuario (id_usuario) 
        ON DELETE CASCADE
);
