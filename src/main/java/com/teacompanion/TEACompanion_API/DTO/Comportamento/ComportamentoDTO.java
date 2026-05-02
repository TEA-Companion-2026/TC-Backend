package com.teacompanion.TEACompanion_API.DTO.Comportamento;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ComportamentoDTO{
    Long idComportamento;
    LocalDateTime data;
    String observacao;
    Long tipoComportamentoId;
}