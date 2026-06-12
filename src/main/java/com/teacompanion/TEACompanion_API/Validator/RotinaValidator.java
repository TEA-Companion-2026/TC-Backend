package com.teacompanion.TEACompanion_API.Validator;

import org.springframework.stereotype.Component;

import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;
import com.teacompanion.TEACompanion_API.Enum.DiaSemanaEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class RotinaValidator {

    public void validarParaCriacao(RotinaDTO dto) {
        validarIdIndividuo(dto.getIdIndividuo());
        validarTitulo(dto.getTitulo());
        validarDiaSemana(dto.getDiaSemana());
        validarHorario(dto);
    }

    public void validarParaAtualizacao(RotinaDTO dto) {
        validarTitulo(dto.getTitulo());
        validarDiaSemana(dto.getDiaSemana());
        validarHorario(dto);
    }

    public DiaSemanaEnum parseDiaSemana(String diaSemana) {
        validarDiaSemana(diaSemana);
        return DiaSemanaEnum.valueOf(diaSemana);
    }

    // ---------- regras individuais ----------

    private void validarIdIndividuo(Long idIndividuo) {
        if (idIndividuo == null) {
            throw new IllegalArgumentException("O ID do indivíduo é obrigatório");
        }
    }

    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da rotina é obrigatório");
        }
        if (titulo.length() > 100) {
            throw new IllegalArgumentException("O título da rotina não pode ultrapassar 100 caracteres");
        }
    }

    private void validarDiaSemana(String diaSemana) {
        if (diaSemana == null || diaSemana.isBlank()) {
            throw new IllegalArgumentException("O dia da semana é obrigatório");
        }

        boolean valido = Arrays.stream(DiaSemanaEnum.values())
                .anyMatch(d -> d.name().equals(diaSemana));

        if (!valido) {
            String valoresAceitos = Arrays.stream(DiaSemanaEnum.values())
                    .map(DiaSemanaEnum::name)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(
                    "Dia da semana inválido: '" + diaSemana + "'. Valores aceitos: " + valoresAceitos);
        }
    }

    private void validarHorario(RotinaDTO dto) {
        if (dto.getHorario() == null) {
            throw new IllegalArgumentException("O horário da rotina é obrigatório");
        }
    }
}
