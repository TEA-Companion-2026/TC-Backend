package com.teacompanion.TEACompanion_API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacompanion.TEACompanion_API.Model.Rotina;

@Repository
public interface RotinaRepository extends JpaRepository<Rotina, Long> {
    List<Rotina> findByIndividuo_Id_usuario(Integer id_usuario);
}
