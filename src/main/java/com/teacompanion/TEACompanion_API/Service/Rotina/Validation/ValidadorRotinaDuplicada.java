package com.teacompanion.TEACompanion_API.Service.Rotina.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;
import com.teacompanion.TEACompanion_API.Repository.RotinaRepository;

@Component
public class ValidadorRotinaDuplicada implements ValidadorRotina {

    @Autowired
    private RotinaRepository rotinaRepository;

    @Override
    public void validar(RotinaDTO dto) {
        // Verifica se já existe uma rotina para o mesmo indivíduo, no mesmo dia e horário
        // Ignora a própria rotina se for uma atualização (dto.getIdRotina() != null)
        boolean existe = rotinaRepository.findByIndividuoId(dto.getIdIndividuo())
                .stream()
                .anyMatch(r -> r.getDiaSemana().name().equals(dto.getDiaSemana()) 
                            && r.getHorario().equals(dto.getHorario())
                            && !r.getIdRotina().equals(dto.getIdRotina()));

        if (existe) {
            throw new RuntimeException("Já existe uma rotina cadastrada para este indivíduo neste dia e horário.");
        }
    }
}
