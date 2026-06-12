package com.teacompanion.TEACompanion_API.Service.Rotina.Validation;

import org.springframework.stereotype.Component;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;
import com.teacompanion.TEACompanion_API.Enum.DiaSemanaEnum;

@Component
public class ValidadorDiaSemanaValido implements ValidadorRotina {
    @Override
    public void validar(RotinaDTO dto) {
        if (dto.getDiaSemana() != null && !dto.getDiaSemana().isBlank()) {
            try {
                DiaSemanaEnum.valueOf(dto.getDiaSemana());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Dia da semana inválido.");
            }
        }
    }
}
