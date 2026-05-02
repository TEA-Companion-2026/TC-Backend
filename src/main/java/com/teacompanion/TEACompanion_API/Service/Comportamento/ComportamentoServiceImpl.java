package com.teacompanion.TEACompanion_API.Service.Comportamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teacompanion.TEACompanion_API.DTO.Comportamento.ComportamentoDTO;
import com.teacompanion.TEACompanion_API.DTO.Comportamento.ComportamentoMapper;
import com.teacompanion.TEACompanion_API.Model.Comportamento;
import com.teacompanion.TEACompanion_API.Model.Psicologo;
import com.teacompanion.TEACompanion_API.Model.Usuario;
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
    public ComportamentoDTO criar(ComportamentoDTO dto, Usuario autor) {
        Comportamento comportamento = comportamentoMapper.toEntity(dto);
        comportamento.setAutor(autor);

        comportamentoRepository.save(comportamento);
        return comportamentoMapper.toDTO(comportamento);
    }

    @Override
    @Transactional(readOnly = true)
    public ComportamentoDTO buscarPorId(Long id, Usuario usuarioLogado) {
        Comportamento comportamento = comportamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comportamento não encontrado com o ID: " + id));

        if (!comportamento.getAutor().equals(usuarioLogado) || !(usuarioLogado instanceof Psicologo)) {
            throw new AccessDeniedException("Você não tem permissão para acessar esse comportamento");
        }

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

        comportamentoMapper.updateEntityFromDTO(comportamento, dto);
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

    @Override
    @Transactional
    public List<ComportamentoDTO> listarComportamentosFiltrados(Usuario usuarioLogado) {
        return (usuarioLogado instanceof Psicologo) ? comportamentoRepository.findAll().stream()
                .map(comportamentoMapper::toDTO)
                .collect(Collectors.toList())
                : comportamentoRepository.findAllByAutor(usuarioLogado).stream()
                        .map(comportamentoMapper::toDTO)
                        .collect(Collectors.toList());
    }
}
