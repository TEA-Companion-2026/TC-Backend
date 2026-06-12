package com.teacompanion.TEACompanion_API.Service.Rotina;

import java.util.List;

import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;

public interface RotinaService {
    RotinaDTO criar(RotinaDTO rotinaDTO);
    RotinaDTO buscarPorId(Long id);
    List<RotinaDTO> listarPorIndividuo(Long idIndividuo);
    List<RotinaDTO> listarPorIndividuoEDia(Long idIndividuo, String diaSemana);
    RotinaDTO atualizar(Long id, RotinaDTO rotinaDTO);
    void deletar(Long id);
}
