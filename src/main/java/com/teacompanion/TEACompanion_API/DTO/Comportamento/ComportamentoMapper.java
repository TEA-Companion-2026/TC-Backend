package com.teacompanion.TEACompanion_API.DTO.Comportamento;


import org.springframework.stereotype.Component;

import com.teacompanion.TEACompanion_API.Enum.TipoComportamentoEnum;
import com.teacompanion.TEACompanion_API.Model.Comportamento;

@Component
public class ComportamentoMapper {

    public Comportamento toEntity(ComportamentoDTO dto) {
        Comportamento entity = new Comportamento();
        entity.setIdComportamento(dto.getIdComportamento());
        entity.setData(dto.getData());
        entity.setObservacao(dto.getObservacao());
        entity.setTipoComportamento(TipoComportamentoEnum.valueOf(dto.getTipoComportamento()));

        return entity;
    }

    public ComportamentoDTO toDTO(Comportamento entity) {
        ComportamentoDTO dto = new ComportamentoDTO();
        dto.setIdComportamento(entity.getIdComportamento());
        dto.setData(entity.getData());
        dto.setObservacao(entity.getObservacao());
        dto.setTipoComportamento(entity.getTipoComportamento().getNome());

        return dto;
    }

    public void updateEntityFromDTO(Comportamento entity, ComportamentoDTO dto) {
        entity.setData(dto.getData());
        entity.setObservacao(dto.getObservacao());
        entity.setTipoComportamento(TipoComportamentoEnum.valueOf(dto.getTipoComportamento()));
    }
}
