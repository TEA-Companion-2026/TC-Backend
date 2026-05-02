CREATE TABLE comportamento (
    id_comportamento INTEGER PRIMARY KEY AUTOINCREMENT,
    data TEXT NOT NULL DEFAULT (date('now')),
    observacao TEXT,
    id_usuario INTEGER NOT NULL,
    
    CONSTRAINT fk_comportamento_usuario 
        FOREIGN KEY (id_usuario) 
        REFERENCES usuario (id_usuario) 
        ON DELETE CASCADE
);