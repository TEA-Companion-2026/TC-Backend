package com.teacompanion.TEACompanion_API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.teacompanion.TEACompanion_API.DTO.Comportamento.ComportamentoDTO;
import com.teacompanion.TEACompanion_API.Model.Usuario;
import com.teacompanion.TEACompanion_API.Service.Comportamento.ComportamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/comportamento")
public class ComportamentoController {

    @Autowired
    private ComportamentoService comportamentoService;

    @PostMapping
    public ResponseEntity<ComportamentoDTO> criar(@RequestBody ComportamentoDTO dto, @AuthenticationPrincipal Usuario usuarioLogado) {
        ComportamentoDTO comportamentoCriado = comportamentoService.criar(dto, usuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body(comportamentoCriado);
    }

    // READ (All) - GET /comportamentos
    @GetMapping
    public ResponseEntity<List<ComportamentoDTO>> listarTodos(@AuthenticationPrincipal Usuario usuarioLogado) {
        List<ComportamentoDTO> lista = comportamentoService.listarComportamentosFiltrados(usuarioLogado);
        return ResponseEntity.ok(lista);
    }

    // READ (By ID) - GET /comportamentos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ComportamentoDTO> buscarPorId(@PathVariable Long id, @AuthenticationPrincipal Usuario usuarioLogado) {
        ComportamentoDTO dto = comportamentoService.buscarPorId(id, usuarioLogado);
        return ResponseEntity.ok(dto);
    }

    // UPDATE - PUT /comportamentos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ComportamentoDTO> atualizar(@PathVariable Long id, @RequestBody ComportamentoDTO dto) {
        ComportamentoDTO comportamentoAtualizado = comportamentoService.atualizar(id, dto);
        return ResponseEntity.ok(comportamentoAtualizado);
    }

    // DELETE - DELETE /comportamentos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comportamentoService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 (Sem Conteúdo) indicando sucesso na exclusão
    }
}