package com.teacompanion.TEACompanion_API.Service.Comportamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teacompanion.TEACompanion_API.DTO.Comportamento.ComportamentoDTO;
import com.teacompanion.TEACompanion_API.DTO.Comportamento.ComportamentoMapper;
import com.teacompanion.TEACompanion_API.Model.Comportamento;
import com.teacompanion.TEACompanion_API.Repository.ComportamentoRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComportamentoServiceImpl implements ComportamentoService {

    @Autowired
    private ComportamentoRepository comportamentoRepository;

    @Autowired
    private ComportamentoMapper comportamentoMapper;
    // private final TipoComportamentoRepository tipoComportamentoRepository;

    @Override
    @Transactional
    public ComportamentoDTO criar(ComportamentoDTO dto) {
        Comportamento comportamento = new Comportamento();
        copiarDtoParaEntidade(dto, comportamento);
        
        comportamento = comportamentoRepository.save(comportamento);
        return comportamentoMapper.toDTO(comportamento);
    }

    @Override
    @Transactional(readOnly = true)
    public ComportamentoDTO buscarPorId(Long id) {
        Comportamento comportamento = comportamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comportamento não encontrado com o ID: " + id));
        return comportamentoMapper.toDTO(comportamento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComportamentoDTO> listarTodos() {
        return comportamentoRepository.findAll().stream()
                .map(comportamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ComportamentoDTO atualizar(Long id, ComportamentoDTO dto) {
        Comportamento comportamento = comportamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comportamento não encontrado com o ID: " + id));
        
        copiarDtoParaEntidade(dto, comportamento);
        comportamento = comportamentoRepository.save(comportamento);
        
        return comportamentoMapper.toDTO(comportamento);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!comportamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Comportamento não encontrado com o ID: " + id);
        }
        comportamentoRepository.deleteById(id);
    }

    // Método utilitário para mapear DTO -> Entidade
    private void copiarDtoParaEntidade(ComportamentoDTO dto, Comportamento entidade) {
        entidade.setData(dto.getData());
        entidade.setObservacao(dto.getObservacao());

        // Busca o TipoComportamento no banco para associar a FK corretamente
        // if (dto.tipoComportamentoId() != null) {
        //     TipoComportamento tipo = tipoComportamentoRepository.findById(dto.tipoComportamentoId())
        //             .orElseThrow(() -> new EntityNotFoundException("Tipo de Comportamento não encontrado"));
        //     entidade.setTipoComportamento(tipo);
        // }
    }
}
