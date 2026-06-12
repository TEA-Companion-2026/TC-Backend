package com.teacompanion.TEACompanion_API.DTO.Individuo;

import org.springframework.stereotype.Component;

import com.teacompanion.TEACompanion_API.Model.Individuo;

@Component
public class IndividuoMapper {

    public Individuo toEntity(IndividuoDTO dto) {
        Individuo entity = new Individuo();
        entity.setIdIndividuo(dto.getIdIndividuo());
        entity.setNome(dto.getNome());
        // psicologo é setado no service
        return entity;
    }

    public IndividuoDTO toDTO(Individuo entity) {
        IndividuoDTO dto = new IndividuoDTO();
        dto.setIdIndividuo(entity.getIdIndividuo());
        dto.setNome(entity.getNome());
        dto.setIdPsicologo(entity.getPsicologo().getId_usuario());
        return dto;
    }

    public void updateEntityFromDTO(Individuo entity, IndividuoDTO dto) {
        entity.setNome(dto.getNome());
    }
}
