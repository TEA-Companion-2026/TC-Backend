package com.teacompanion.TEACompanion_API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teacompanion.TEACompanion_API.Model.Rotina;

@Repository
public interface RotinaRepository extends JpaRepository<Rotina, Long> {
    
    @Query("SELECT r FROM Rotina r WHERE r.individuo.id_usuario = :idIndividuo")
    List<Rotina> findByIndividuoId(@Param("idIndividuo") Integer idIndividuo);
}
