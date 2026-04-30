package com.teacompanion.TEACompanion_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teacompanion.TEACompanion_API.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
<<<<<<< HEAD
    Usuario findByEmail(String email);
=======
    
>>>>>>> 54bde754efa62c338145a0faa1bd6e9f1da4ec51
}
