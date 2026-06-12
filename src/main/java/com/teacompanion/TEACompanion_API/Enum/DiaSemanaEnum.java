package com.teacompanion.TEACompanion_API.Enum;

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
}
