package com.teacompanion.TEACompanion_API.Service.Individuo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoDTO;
import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoMapper;
import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Repository.IndividuoRepository;

@Service
public class IndividuoServiceImpl implements IndividuoService {

    @Autowired
    private IndividuoRepository individuoRepository;

    @Autowired
    private IndividuoMapper individuoMapper;

    @Override
    public IndividuoDTO criar(IndividuoDTO dto) {
        validarDTO(dto);
        Individuo entity = individuoMapper.toEntity(dto);
        
        // Garantindo que indivíduos não tenham credenciais de acesso
        entity.setUsername(null);
        entity.setPassword(null);
        
        entity = individuoRepository.save(entity);
        return individuoMapper.toDTO(entity);
    }

    @Override
    public List<IndividuoDTO> listarTodos() {
        return individuoRepository.findAll()
                .stream()
                .map(individuoMapper::toDTO)
                .toList();
    }

    @Override
    public IndividuoDTO buscarPorId(Integer id) {
        Individuo entity = individuoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Indivíduo não encontrado!"));
        return individuoMapper.toDTO(entity);
    }

    @Override
    public IndividuoDTO atualizar(Integer id, IndividuoDTO dto) {
        validarDTO(dto);
        Individuo entity = individuoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Indivíduo não encontrado!"));
        
        individuoMapper.updateEntityFromDTO(entity, dto);
        
        // Mantendo a restrição de acesso no update
        entity.setUsername(null);
        entity.setPassword(null);

        entity = individuoRepository.save(entity);
        return individuoMapper.toDTO(entity);
    }

    @Override
    public void deletar(Integer id) {
        Individuo entity = individuoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Indivíduo não encontrado!"));
        individuoRepository.delete(entity);
    }

    private void validarDTO(IndividuoDTO dto) {
        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RuntimeException("O nome do indivíduo é obrigatório.");
        }
    }
}
