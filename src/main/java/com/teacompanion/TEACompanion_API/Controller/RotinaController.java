package com.teacompanion.TEACompanion_API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacompanion.TEACompanion_API.DTO.Rotina.RotinaDTO;
import com.teacompanion.TEACompanion_API.Service.Rotina.RotinaService;

@RestController
@RequestMapping("/api/rotina")
public class RotinaController {

    @Autowired
    private RotinaService rotinaService;

    @PostMapping
    public ResponseEntity<RotinaDTO> criar(@RequestBody RotinaDTO dto) {
        RotinaDTO rotinaCriada = rotinaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(rotinaCriada);
    }

    @GetMapping("/individuo/{idIndividuo}")
    public ResponseEntity<List<RotinaDTO>> listarPorIndividuo(@PathVariable Integer idIndividuo) {
        List<RotinaDTO> lista = rotinaService.listarPorIndividuo(idIndividuo);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotinaDTO> buscarPorId(@PathVariable Long id) {
        RotinaDTO dto = rotinaService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RotinaDTO> atualizar(@PathVariable Long id, @RequestBody RotinaDTO dto) {
        RotinaDTO rotinaAtualizada = rotinaService.atualizar(id, dto);
        return ResponseEntity.ok(rotinaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        rotinaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
