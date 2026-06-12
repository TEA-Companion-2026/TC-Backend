package com.teacompanion.TEACompanion_API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacompanion.TEACompanion_API.Enum.DiaSemanaEnum;
import com.teacompanion.TEACompanion_API.Model.Individuo;
import com.teacompanion.TEACompanion_API.Model.Rotina;

@Repository
public interface RotinaRepository extends JpaRepository<Rotina, Long> {
    List<Rotina> findAllByIndividuo(Individuo individuo);
    List<Rotina> findAllByIndividuoAndDiaSemana(Individuo individuo, DiaSemanaEnum diaSemana);
}
