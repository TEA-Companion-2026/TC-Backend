package com.teacompanion.TEACompanion_API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacompanion.TEACompanion_API.Model.Comportamento;
import com.teacompanion.TEACompanion_API.Model.Usuario;

@Repository
public interface ComportamentoRepository extends JpaRepository<Comportamento, Long> {
    List<Comportamento> findAllByAutor(Usuario autor);
}
