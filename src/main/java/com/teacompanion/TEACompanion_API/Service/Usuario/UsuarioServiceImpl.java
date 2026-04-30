package com.teacompanion.TEACompanion_API.Service.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacompanion.TEACompanion_API.DTO.Usuario.UsuarioDTO;
import com.teacompanion.TEACompanion_API.DTO.Usuario.UsuarioMapper;
import com.teacompanion.TEACompanion_API.Model.Usuario;
import com.teacompanion.TEACompanion_API.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }

    @Override
    public UsuarioDTO getByID(Integer id_usuario) {
        Usuario usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioDTO store(UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.save(usuarioMapper.toEntity(dto));
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioDTO update(Integer id_usuario, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        usuarioMapper.updateEntityFromDTO(usuario, dto);

        usuarioRepository.save(usuario);

        return usuarioMapper.toDTO(usuario);
    }

}
