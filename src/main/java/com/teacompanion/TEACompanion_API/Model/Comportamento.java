package com.teacompanion.TEACompanion_API.Model;

import java.time.LocalDateTime;

import com.teacompanion.TEACompanion_API.Enum.TipoComportamentoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comportamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comportamento")
    private Long idComportamento;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(length = 500)
    private String observacao;

    @JoinColumn(name = "tipo_comportamento", nullable = false)
    private TipoComportamentoEnum tipoComportamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario autor;
}