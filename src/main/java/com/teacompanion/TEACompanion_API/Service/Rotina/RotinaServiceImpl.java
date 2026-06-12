package com.teacompanion.TEACompanion_API.Service.Rotina;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;
import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaMapper;
import com.teacompanion.TEACompanion_API.Enum.DiaSemanaEnum;
import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Model.Rotina;
import com.teacompanion.TEACompanion_API.Repository.IndividuoRepository;
import com.teacompanion.TEACompanion_API.Repository.RotinaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RotinaServiceImpl implements RotinaService {

    @Autowired
    private RotinaRepository rotinaRepository;

    @Autowired
    private IndividuoRepository individuoRepository;

    @Autowired
    private RotinaMapper rotinaMapper;

    @Override
    @Transactional
    public RotinaDTO criar(RotinaDTO dto) {
        Individuo individuo = buscarIndividuo(dto.getIdIndividuo());

        validarDiaSemana(dto.getDiaSemana());

        Rotina rotina = rotinaMapper.toEntity(dto);
        rotina.setIndividuo(individuo);

        rotinaRepository.save(rotina);
        return rotinaMapper.toDTO(rotina);
    }

    @Override
    @Transactional(readOnly = true)
    public RotinaDTO buscarPorId(Long id) {
        Rotina rotina = buscarRotina(id);
        return rotinaMapper.toDTO(rotina);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RotinaDTO> listarPorIndividuo(Long idIndividuo) {
        Individuo individuo = buscarIndividuo(idIndividuo);
        return rotinaRepository.findAllByIndividuo(individuo).stream()
                .sorted((a, b) -> {
                    int diaComp = a.getDiaSemana().compareTo(b.getDiaSemana());
                    if (diaComp != 0) return diaComp;
                    return a.getHorario().compareTo(b.getHorario());
                })
                .map(rotinaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RotinaDTO> listarPorIndividuoEDia(Long idIndividuo, String diaSemana) {
        Individuo individuo = buscarIndividuo(idIndividuo);
        DiaSemanaEnum dia = validarDiaSemana(diaSemana);

        return rotinaRepository.findAllByIndividuoAndDiaSemana(individuo, dia).stream()
                .sorted((a, b) -> a.getHorario().compareTo(b.getHorario()))
                .map(rotinaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RotinaDTO atualizar(Long id, RotinaDTO dto) {
        Rotina rotina = buscarRotina(id);

        validarDiaSemana(dto.getDiaSemana());

        rotinaMapper.updateEntityFromDTO(rotina, dto);
        rotina = rotinaRepository.save(rotina);

        return rotinaMapper.toDTO(rotina);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!rotinaRepository.existsById(id)) {
            throw new EntityNotFoundException("Rotina não encontrada com o ID: " + id);
        }
        rotinaRepository.deleteById(id);
    }

    // ---------- helpers privados ----------

    private Rotina buscarRotina(Long id) {
        return rotinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rotina não encontrada com o ID: " + id));
    }

    private Individuo buscarIndividuo(Long idIndividuo) {
        if (idIndividuo == null) {
            throw new IllegalArgumentException("O ID do indivíduo é obrigatório");
        }
        return individuoRepository.findById(idIndividuo)
                .orElseThrow(() -> new EntityNotFoundException("Indivíduo não encontrado com o ID: " + idIndividuo));
    }

    private DiaSemanaEnum validarDiaSemana(String diaSemana) {
        try {
            return DiaSemanaEnum.valueOf(diaSemana);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Dia da semana inválido: '" + diaSemana +
                    "'. Valores aceitos: SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO");
        }
    }
}
