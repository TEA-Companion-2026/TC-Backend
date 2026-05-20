package com.teacompanion.TEACompanion_API.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacompanion.TEACompanion_API.Enum.TipoComportamentoEnum;

@RestController
@RequestMapping("/api/tipo-comportamento")
public class TipoComportamentoController {
    @GetMapping
    public ResponseEntity<List<Map<String, String>>> index() {
        return ResponseEntity.ok(TipoComportamentoEnum.getAll());
    }
}
