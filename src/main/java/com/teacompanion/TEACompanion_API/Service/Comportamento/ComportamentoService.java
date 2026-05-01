package com.teacompanion.TEACompanion_API.Service.Comportamento;

import java.util.List;

import com.teacompanion.TEACompanion_API.DTO.Comportamento.ComportamentoDTO;

public interface ComportamentoService {
    ComportamentoDTO criar(ComportamentoDTO comportamentoDTO);
    ComportamentoDTO buscarPorId(Long id);
    List<ComportamentoDTO> listarTodos();
    ComportamentoDTO atualizar(Long id, ComportamentoDTO comportamentoDTO);
    void deletar(Long id);
}
