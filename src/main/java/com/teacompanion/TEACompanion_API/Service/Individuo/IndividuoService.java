package com.teacompanion.TEACompanion_API.Service.Individuo;

import java.util.List;

import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoDTO;
import com.teacompanion.TEACompanion_API.Model.Usuario;

public interface IndividuoService {
    IndividuoDTO criar(IndividuoDTO individuoDTO, Usuario usuarioLogado);
    IndividuoDTO buscarPorId(Long id, Usuario usuarioLogado);
    List<IndividuoDTO> listarPorPsicologo(Usuario usuarioLogado);
    IndividuoDTO atualizar(Long id, IndividuoDTO individuoDTO, Usuario usuarioLogado);
    void deletar(Long id, Usuario usuarioLogado);
}
