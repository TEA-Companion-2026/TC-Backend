package com.teacompanion.TEACompanion_API.Service.Rotina.Validation;

import org.springframework.stereotype.Component;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;

@Component
public class ValidadorHorarioObrigatorio implements ValidadorRotina {
    @Override
    public void validar(RotinaDTO dto) {
        if (dto.getHorario() == null) {
            throw new RuntimeException("O horário da rotina é obrigatório.");
        }
    }
}
