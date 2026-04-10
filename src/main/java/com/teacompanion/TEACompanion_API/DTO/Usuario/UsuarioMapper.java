package com.teacompanion.TEACompanion_API.DTO.Usuario;

import org.springframework.stereotype.Component;

import com.teacompanion.TEACompanion_API.Model.Usuario;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioDTO dto){
        Usuario entity = new Usuario();
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setId_usuario(dto.getId_usuario());
        return entity;
    }

    public UsuarioDTO toDTO(Usuario entity){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(entity.getEmail());
        dto.setNome(entity.getNome());
        dto.setId_usuario(entity.getId_usuario());
        return dto;
    }

    public void updateEntityFromDTO(Usuario entity, UsuarioDTO dto){
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setId_usuario(dto.getId_usuario());
    }
}
