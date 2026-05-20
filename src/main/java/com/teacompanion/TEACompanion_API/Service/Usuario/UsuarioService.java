package com.teacompanion.TEACompanion_API.Service.Usuario;

import java.util.List;

import com.teacompanion.TEACompanion_API.DTO.Usuario.UsuarioDTO;

public interface UsuarioService {
    public List<UsuarioDTO> getAll();
    public UsuarioDTO getByID(Integer id_usuario);
    public UsuarioDTO store(UsuarioDTO dto);
    public UsuarioDTO update(Integer id_usuario, UsuarioDTO dto); 
}