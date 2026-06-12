package com.teacompanion.TEACompanion_API.Service.Rotina.Validation;

import org.springframework.stereotype.Component;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;

@Component
public class ValidadorDiaSemanaObrigatorio implements ValidadorRotina {
    @Override
    public void validar(RotinaDTO dto) {
        if (dto.getDiaSemana() == null || dto.getDiaSemana().isBlank()) {
            throw new RuntimeException("O dia da semana é obrigatório.");
        }
    }
}
