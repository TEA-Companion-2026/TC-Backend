package com.teacompanion.TEACompanion_API.DTO.Comportamento;


import org.springframework.stereotype.Component;

import com.teacompanion.TEACompanion_API.Model.Comportamento;

@Component
public class ComportamentoMapper {

    public Comportamento toEntity(ComportamentoDTO dto) {
        Comportamento entity = new Comportamento();
        entity.setIdComportamento(dto.getIdComportamento());
        entity.setData(dto.getData());
        entity.setObservacao(dto.getObservacao());

        // if (dto.getTipoComportamentoId() != null) {
        //     TipoComportamento tipo = new TipoComportamento();
        //     tipo.setId(dto.getTipoComportamentoId()); // Assumindo que a PK de TipoComportamento se chama 'id'
        //     entity.setTipoComportamento(tipo);
        // }

        return entity;
    }

    public ComportamentoDTO toDTO(Comportamento entity) {
        ComportamentoDTO dto = new ComportamentoDTO();
        dto.setIdComportamento(entity.getIdComportamento());
        dto.setData(entity.getData());
        dto.setObservacao(entity.getObservacao());

        // // Tratamento da Chave Estrangeira (FK)
        // if (entity.getTipoComportamento() != null) {
        //     dto.setTipoComportamentoId(entity.getTipoComportamento().getId());
        // }

        return dto;
    }

    public void updateEntityFromDTO(Comportamento entity, ComportamentoDTO dto) {
        entity.setData(dto.getData());
        entity.setObservacao(dto.getObservacao());

        // if (dto.getTipoComportamentoId() != null) {
        //     TipoComportamento tipo = new TipoComportamento();
        //     tipo.setId(dto.getTipoComportamentoId());
        //     entity.setTipoComportamento(tipo);
        // } else {
        //     entity.setTipoComportamento(null); // Caso o envio seja nulo, remove o relacionamento
        // }
    }
}
