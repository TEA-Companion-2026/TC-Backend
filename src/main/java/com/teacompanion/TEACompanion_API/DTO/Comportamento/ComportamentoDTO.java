package com.teacompanion.TEACompanion_API.DTO.Comportamento;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ComportamentoDTO{
    Long idComportamento;
    LocalDate data;
    String observacao;
    Long tipoComportamentoId;
}