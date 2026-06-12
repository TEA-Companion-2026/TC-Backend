package com.teacompanion.TEACompanion_API.Service.Individuo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoDTO;
import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoMapper;
import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Model.Psicologo;
import com.teacompanion.TEACompanion_API.Model.Usuario;
import com.teacompanion.TEACompanion_API.Repository.IndividuoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IndividuoServiceImpl implements IndividuoService {

    @Autowired
    private IndividuoRepository individuoRepository;

    @Autowired
    private IndividuoMapper individuoMapper;

    @Override
    @Transactional
    public IndividuoDTO criar(IndividuoDTO dto, Usuario usuarioLogado) {
        Psicologo psicologo = exigirPsicologo(usuarioLogado);

        Individuo individuo = individuoMapper.toEntity(dto);
        individuo.setPsicologo(psicologo);

        individuoRepository.save(individuo);
        return individuoMapper.toDTO(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public IndividuoDTO buscarPorId(Long id, Usuario usuarioLogado) {
        Individuo individuo = buscarIndividuo(id);
        validarAcesso(individuo, usuarioLogado);
        return individuoMapper.toDTO(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IndividuoDTO> listarPorPsicologo(Usuario usuarioLogado) {
        Psicologo psicologo = exigirPsicologo(usuarioLogado);
        return individuoRepository.findAllByPsicologo(psicologo).stream()
                .map(individuoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public IndividuoDTO atualizar(Long id, IndividuoDTO dto, Usuario usuarioLogado) {
        Individuo individuo = buscarIndividuo(id);
        validarAcesso(individuo, usuarioLogado);

        individuoMapper.updateEntityFromDTO(individuo, dto);
        individuo = individuoRepository.save(individuo);

        return individuoMapper.toDTO(individuo);
    }

    @Override
    @Transactional
    public void deletar(Long id, Usuario usuarioLogado) {
        Individuo individuo = buscarIndividuo(id);
        validarAcesso(individuo, usuarioLogado);
        individuoRepository.deleteById(id);
    }

    // ---------- helpers privados ----------

    private Individuo buscarIndividuo(Long id) {
        return individuoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Indivíduo não encontrado com o ID: " + id));
    }

    private Psicologo exigirPsicologo(Usuario usuarioLogado) {
        if (!(usuarioLogado instanceof Psicologo psicologo)) {
            throw new AccessDeniedException("Apenas psicólogos podem realizar esta operação");
        }
        return psicologo;
    }

    private void validarAcesso(Individuo individuo, Usuario usuarioLogado) {
        if (!(usuarioLogado instanceof Psicologo) ||
                !individuo.getPsicologo().getId_usuario().equals(usuarioLogado.getId_usuario())) {
            throw new AccessDeniedException("Você não tem permissão para acessar este indivíduo");
        }
    }
}
