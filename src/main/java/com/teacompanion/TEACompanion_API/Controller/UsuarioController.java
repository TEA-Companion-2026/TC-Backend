package com.teacompanion.TEACompanion_API.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacompanion.TEACompanion_API.DTO.Usuario.UsuarioDTO;
import com.teacompanion.TEACompanion_API.Service.Usuario.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> index() {
        return usuarioService.getAll();
    }
    
    @GetMapping("/{id_usuario}")
    public UsuarioDTO show(@PathVariable Integer id_usuario) {
        return usuarioService.getByID(id_usuario);
    }

    @PostMapping
    public UsuarioDTO create(@RequestBody UsuarioDTO dto) {
        return usuarioService.store(dto);
    }
    
    @PutMapping("/{id_usuario}")
    public UsuarioDTO edit(@PathVariable Integer id_usuario, @RequestBody UsuarioDTO dto) {
        return usuarioService.update(id_usuario, dto);
    }
}
