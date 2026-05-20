package com.teacompanion.TEACompanion_API.Service.Comportamento;

import java.util.List;

import com.teacompanion.TEACompanion_API.DTO.Comportamento.ComportamentoDTO;
import com.teacompanion.TEACompanion_API.Model.Usuario;

public interface ComportamentoService {
    ComportamentoDTO criar(ComportamentoDTO comportamentoDTO, Usuario autor);
    ComportamentoDTO buscarPorId(Long id, Usuario usuarioLogado);
    List<ComportamentoDTO> listarTodos();
    List<ComportamentoDTO> listarComportamentosFiltrados(Usuario usuarioLogado);
    ComportamentoDTO atualizar(Long id, ComportamentoDTO comportamentoDTO);
    void deletar(Long id);
}
