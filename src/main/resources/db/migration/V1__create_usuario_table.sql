CREATE TABLE usuario (
    id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
    nivel_acesso TEXT NOT NULL, 
    username TEXT,
    password TEXT,
    nome TEXT,
    email TEXT
);