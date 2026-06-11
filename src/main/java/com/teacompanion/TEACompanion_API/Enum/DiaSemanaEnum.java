package com.teacompanion.TEACompanion_API.Enum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DiaSemanaEnum {
    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    private final String nome;

    DiaSemanaEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static List<Map<String, String>> getAll() {
        List<Map<String, String>> lista = new ArrayList<>();
        for (DiaSemanaEnum dia : values()) {
            Map<String, String> objeto = new HashMap<>();
            objeto.put("chave", dia.name());
            objeto.put("nome", dia.getNome());
            lista.add(objeto);
        }
        return lista;
    }
}
