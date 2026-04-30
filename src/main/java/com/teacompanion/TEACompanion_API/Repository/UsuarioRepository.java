package com.teacompanion.TEACompanion_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teacompanion.TEACompanion_API.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
