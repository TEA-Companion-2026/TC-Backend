package com.teacompanion.TEACompanion_API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoDTO;
import com.teacompanion.TEACompanion_API.Model.Usuario;
import com.teacompanion.TEACompanion_API.Service.Individuo.IndividuoService;

@RestController
@RequestMapping("/api/individuo")
public class IndividuoController {

    @Autowired
    private IndividuoService individuoService;

    @PostMapping
    public ResponseEntity<IndividuoDTO> criar(@RequestBody IndividuoDTO dto,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        IndividuoDTO individuoCriado = individuoService.criar(dto, usuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body(individuoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndividuoDTO> buscarPorId(@PathVariable Long id,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        IndividuoDTO dto = individuoService.buscarPorId(id, usuarioLogado);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<IndividuoDTO>> listarMeusIndividuos(
            @AuthenticationPrincipal Usuario usuarioLogado) {
        List<IndividuoDTO> lista = individuoService.listarPorPsicologo(usuarioLogado);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndividuoDTO> atualizar(@PathVariable Long id,
            @RequestBody IndividuoDTO dto,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        IndividuoDTO individuoAtualizado = individuoService.atualizar(id, dto, usuarioLogado);
        return ResponseEntity.ok(individuoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        individuoService.deletar(id, usuarioLogado);
        return ResponseEntity.noContent().build();
    }
}
