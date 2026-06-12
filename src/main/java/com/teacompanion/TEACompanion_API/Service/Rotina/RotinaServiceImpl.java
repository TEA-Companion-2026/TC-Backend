package com.teacompanion.TEACompanion_API.Service.Rotina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaMapper;
import com.teacompanion.TEACompanion_API.Enum.DiaSemanaEnum;
import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Model.Rotina;
import com.teacompanion.TEACompanion_API.Repository.IndividuoRepository;
import com.teacompanion.TEACompanion_API.Repository.RotinaRepository;

@Service
public class RotinaServiceImpl implements RotinaService {

    @Autowired
    private RotinaRepository rotinaRepository;

    @Autowired
    private IndividuoRepository individuoRepository;

    @Autowired
    private RotinaMapper rotinaMapper;

    @Override
    public RotinaDTO criar(RotinaDTO dto) {
        validarDTO(dto);

        if (dto.getIdIndividuo() == null) {
            throw new RuntimeException("ID do indivíduo é obrigatório para cadastrar uma rotina.");
        }

        Individuo individuo = individuoRepository.findById(dto.getIdIndividuo())
                .orElseThrow(() -> new RuntimeException("Indivíduo não encontrado!"));

        Rotina entity = rotinaMapper.toEntity(dto, individuo);
        entity = rotinaRepository.save(entity);
        return rotinaMapper.toDTO(entity);
    }

    @Override
    public List<RotinaDTO> listarPorIndividuo(Integer idIndividuo) {
        return rotinaRepository.findByIndividuo_Id_usuario(idIndividuo)
                .stream()
                .map(rotinaMapper::toDTO)
                .toList();
    }

    @Override
    public RotinaDTO buscarPorId(Long id) {
        Rotina entity = rotinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rotina não encontrada!"));
        return rotinaMapper.toDTO(entity);
    }

    @Override
    public RotinaDTO atualizar(Long id, RotinaDTO dto) {
        validarDTO(dto);
        
        Rotina entity = rotinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rotina não encontrada!"));

        rotinaMapper.updateEntityFromDTO(entity, dto);
        entity = rotinaRepository.save(entity);
        return rotinaMapper.toDTO(entity);
    }

    private void validarDTO(RotinaDTO dto) {
        if (dto.getTitulo() == null || dto.getTitulo().isBlank()) {
            throw new RuntimeException("O título da rotina é obrigatório.");
        }
        if (dto.getDiaSemana() == null) {
            throw new RuntimeException("O dia da semana é obrigatório.");
        }
        try {
            DiaSemanaEnum.valueOf(dto.getDiaSemana());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Dia da semana inválido.");
        }
        if (dto.getHorario() == null) {
            throw new RuntimeException("O horário da rotina é obrigatório.");
        }
    }

    @Override
    public void deletar(Long id) {
        Rotina entity = rotinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rotina não encontrada!"));
        rotinaRepository.delete(entity);
    }
}
