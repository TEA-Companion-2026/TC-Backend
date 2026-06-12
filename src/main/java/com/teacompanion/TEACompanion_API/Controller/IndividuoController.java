package com.teacompanion.TEACompanion_API.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teacompanion.TEACompanion_API.DTO.Individuo.IndividuoDTO;
import com.teacompanion.TEACompanion_API.Service.Individuo.IndividuoService;

@RestController
@RequestMapping("/api/individuo")
public class IndividuoController {

    @Autowired
    private IndividuoService individuoService;

    @PostMapping
    public ResponseEntity<IndividuoDTO> criar(@RequestBody IndividuoDTO dto) {
        IndividuoDTO criado = individuoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<IndividuoDTO>> listarTodos() {
        List<IndividuoDTO> lista = individuoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndividuoDTO> buscarPorId(@PathVariable Integer id) {
        IndividuoDTO dto = individuoService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndividuoDTO> atualizar(@PathVariable Integer id, @RequestBody IndividuoDTO dto) {
        IndividuoDTO atualizado = individuoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        individuoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
