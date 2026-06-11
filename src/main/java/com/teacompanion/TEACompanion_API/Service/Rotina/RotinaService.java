package com.teacompanion.TEACompanion_API.Service.Rotina;

import java.util.List;

import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;

public interface RotinaService {
    RotinaDTO criar(RotinaDTO dto);
    List<RotinaDTO> listarPorIndividuo(Integer idIndividuo);
    RotinaDTO buscarPorId(Long id);
    RotinaDTO atualizar(Long id, RotinaDTO dto);
    void deletar(Long id);
}
