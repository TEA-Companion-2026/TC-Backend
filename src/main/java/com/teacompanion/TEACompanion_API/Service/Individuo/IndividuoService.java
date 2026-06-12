package com.teacompanion.TEACompanion_API.Service.Individuo;

import java.util.List;
import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoDTO;

public interface IndividuoService {
    IndividuoDTO criar(IndividuoDTO dto);
    List<IndividuoDTO> listarTodos();
    IndividuoDTO buscarPorId(Integer id);
    IndividuoDTO atualizar(Integer id, IndividuoDTO dto);
    void deletar(Integer id);
}
