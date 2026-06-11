package com.teacompanion.TEACompanion_API.DTO.Rotina;

import org.springframework.stereotype.Component;

import com.teacompanion.TEACompanion_API.Enum.DiaSemanaEnum;
import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Model.Rotina;

@Component
public class RotinaMapper {

    public Rotina toEntity(RotinaDTO dto, Individuo individuo) {
        Rotina entity = new Rotina();
        entity.setIdRotina(dto.getIdRotina());
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDiaSemana(DiaSemanaEnum.valueOf(dto.getDiaSemana()));
        entity.setHorario(dto.getHorario());
        entity.setIndividuo(individuo);

        return entity;
    }

    public RotinaDTO toDTO(Rotina entity) {
        RotinaDTO dto = new RotinaDTO();
        dto.setIdRotina(entity.getIdRotina());
        dto.setTitulo(entity.getTitulo());
        dto.setDescricao(entity.getDescricao());
        dto.setDiaSemana(entity.getDiaSemana().name());
        dto.setHorario(entity.getHorario());
        dto.setIdIndividuo(entity.getIndividuo().getId_usuario());

        return dto;
    }

    public void updateEntityFromDTO(Rotina entity, RotinaDTO dto) {
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDiaSemana(DiaSemanaEnum.valueOf(dto.getDiaSemana()));
        entity.setHorario(dto.getHorario());
    }
}
