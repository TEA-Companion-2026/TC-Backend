package com.teacompanion.TEACompanion_API.Service.Rotina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaMapper;
import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Model.Rotina;
import com.teacompanion.TEACompanion_API.Repository.IndividuoRepository;
import com.teacompanion.TEACompanion_API.Repository.RotinaRepository;
import com.teacompanion.TEACompanion_API.Service.Rotina.Validation.ValidadorRotina;

@Service
public class RotinaServiceImpl implements RotinaService {

    @Autowired
    private RotinaRepository rotinaRepository;

    @Autowired
    private IndividuoRepository individuoRepository;

    @Autowired
    private RotinaMapper rotinaMapper;

    @Autowired
    private List<ValidadorRotina> validadores;

    @Override
    public RotinaDTO criar(RotinaDTO dto) {
        validadores.forEach(v -> v.validar(dto));

        Individuo individuo = individuoRepository.findById(dto.getIdIndividuo())
                .orElseThrow(() -> new RuntimeException("Indivíduo não encontrado!"));

        Rotina entity = rotinaMapper.toEntity(dto, individuo);
        entity = rotinaRepository.save(entity);
        return rotinaMapper.toDTO(entity);
    }

    @Override
    public List<RotinaDTO> listarPorIndividuo(Integer idIndividuo) {
        return rotinaRepository.findByIndividuoId(idIndividuo)
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
        Rotina entity = rotinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rotina não encontrada!"));

        // Garante que o DTO tenha o ID da rotina e do indivíduo para os validadores
        dto.setIdRotina(id);
        if (dto.getIdIndividuo() == null) {
            dto.setIdIndividuo(entity.getIndividuo().getId_usuario());
        }

        validadores.forEach(v -> v.validar(dto));
        
        rotinaMapper.updateEntityFromDTO(entity, dto);
        entity = rotinaRepository.save(entity);
        return rotinaMapper.toDTO(entity);
    }

    @Override
    public void deletar(Long id) {
        Rotina entity = rotinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rotina não encontrada!"));
        rotinaRepository.delete(entity);
    }
}
