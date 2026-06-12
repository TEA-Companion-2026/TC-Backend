package com.teacompanion.TEACompanion_API.Service.Rotina.Validation;

import org.springframework.stereotype.Component;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;

@Component
public class ValidadorTituloObrigatorio implements ValidadorRotina {
    @Override
    public void validar(RotinaDTO dto) {
        if (dto.getTitulo() == null || dto.getTitulo().isBlank()) {
            throw new RuntimeException("O título da rotina é obrigatório.");
        }
    }
}
