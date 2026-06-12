package com.teacompanion.TEACompanion_API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Model.Psicologo;

@Repository
public interface IndividuoRepository extends JpaRepository<Individuo, Long> {
    List<Individuo> findAllByPsicologo(Psicologo psicologo);
}
