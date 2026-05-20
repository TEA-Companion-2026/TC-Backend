package com.teacompanion.TEACompanion_API.Enum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoComportamentoEnum {
    STIMMING(
        "Stimming (Autoestimulação)", 
        "Movimentos, sons ou ações repetitivas usadas para regulação sensorial e emocional (ex: balançar as mãos, balançar o tronco)."
    ),
    
    HIPERFOCO(
        "Hiperfoco", 
        "Atenção intensa, profunda e duradoura direcionada a um interesse ou tema específico."
    ),
    
    RIGIDEZ_DE_ROTINA(
        "Rigidez de Rotina", 
        "Forte necessidade de previsibilidade, padrões e dificuldade para lidar com mudanças inesperadas no dia a dia."
    ),
    
    HIPERSENSIBILIDADE(
        "Hipersensibilidade Sensorial", 
        "Reatividade elevada a estímulos do ambiente (luzes fortes, sons altos, texturas de roupas ou alimentos)."
    ),
    
    HIPOSENSIBILIDADE(
        "Hiposensibilidade Sensorial", 
        "Baixa reatividade a estímulos do ambiente, podendo levar à busca por sensações físicas intensas (tocar muito nas coisas, buscar pressão profunda)."
    ),
    
    ECOLALIA(
        "Ecolalia", 
        "Repetição de sons, palavras ou frases ouvidas recentemente ou no passado, usada muitas vezes como forma de processamento da linguagem ou comunicação."
    ),
    
    MELTDOWN(
        "Meltdown (Crise Externa)", 
        "Reação involuntária de sobrecarga sensorial ou emocional extrema, que se manifesta externamente (choro intenso, fuga, perda temporária de controle)."
    ),
    
    SHUTDOWN(
        "Shutdown (Crise Interna)", 
        "Reação involuntária de sobrecarga extrema onde o indivíduo se retrai internamente, podendo apresentar mutismo seletivo e desconexão com o ambiente."
    ),
    
    DIFICULDADE_COMUNICACAO_SOCIAL(
        "Desafios na Comunicação Social", 
        "Diferenças na interpretação de linguagem não verbal, sarcasmo, contato visual ou reciprocidade social típica."
    );

    private final String nome;
    private final String descricao;

    TipoComportamentoEnum(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.nome + ": " + this.descricao;
    }

    public static List<Map<String, String>> getAll() {
        List<Map<String, String>> lista = new ArrayList<>();

        for (TipoComportamentoEnum tipo : values()) {
            Map<String, String> objeto = new HashMap<>();
            objeto.put("chave", tipo.name());
            objeto.put("nome", tipo.getNome());
            objeto.put("descricao", tipo.getDescricao());
            lista.add(objeto);
        }
        return lista;
    }
}
