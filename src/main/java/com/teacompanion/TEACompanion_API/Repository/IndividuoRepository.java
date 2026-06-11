package com.teacompanion.TEACompanion_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacompanion.TEACompanion_API.Model.Individuo;

@Repository
public interface IndividuoRepository extends JpaRepository<Individuo, Integer> {
}
