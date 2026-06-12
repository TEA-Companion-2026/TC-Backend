package com.teacompanion.TEACompanion_API.DTO.Individuo;

import org.springframework.stereotype.Component;
import com.teacompanion.TEACompanion_API.Model.Individuo;

@Component
public class IndividuoMapper {

    public Individuo toEntity(IndividuoDTO dto) {
        Individuo entity = new Individuo();
        entity.setId_usuario(dto.getId_usuario());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public IndividuoDTO toDTO(Individuo entity) {
        IndividuoDTO dto = new IndividuoDTO();
        dto.setId_usuario(entity.getId_usuario());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public void updateEntityFromDTO(Individuo entity, IndividuoDTO dto) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
    }
}
