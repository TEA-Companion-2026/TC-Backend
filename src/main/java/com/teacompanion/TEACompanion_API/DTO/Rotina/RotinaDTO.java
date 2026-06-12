package com.teacompanion.TEACompanion_API.DTO.Rotina;

import java.time.LocalTime;

import lombok.Data;

@Data
public class RotinaDTO {
    private Long idRotina;
    private String titulo;
    private String descricao;
    private String diaSemana;
    private LocalTime horario;
    private Long idIndividuo;
}
