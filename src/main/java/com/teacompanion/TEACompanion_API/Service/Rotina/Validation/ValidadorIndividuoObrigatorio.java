package com.teacompanion.TEACompanion_API.Service.Rotina.Validation;

import org.springframework.stereotype.Component;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;

@Component
public class ValidadorIndividuoObrigatorio implements ValidadorRotina {
    @Override
    public void validar(RotinaDTO dto) {
        // Para criação, o ID do indivíduo é obrigatório. 
        // Em uma refatoração mais avançada poderíamos separar validadores de criação e atualização,
        // mas por enquanto vamos manter a lógica que já existia.
        if (dto.getIdIndividuo() == null && dto.getIdRotina() == null) {
            throw new RuntimeException("ID do indivíduo é obrigatório para cadastrar uma rotina.");
        }
    }
}
