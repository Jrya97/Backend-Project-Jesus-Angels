package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Nota;
import com.projectjesusangels.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @GetMapping
    public ResponseEntity<List<Nota>> getAllNotas() {
        return ResponseEntity.ok(notaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Integer id) {
        return ResponseEntity.ok(notaService.findById(id));
    }

    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<Nota>> getNotasByAlumno(@PathVariable Integer idAlumno) {
        return ResponseEntity.ok(notaService.findByAlumno(idAlumno));
    }

    @GetMapping("/tipo-nota/{tipoNota}")
    public ResponseEntity<List<Nota>> getNotasByTipoNota(@PathVariable String tipoNota) {
        return ResponseEntity.ok(notaService.findByTipoNota(tipoNota));
    }

    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<Nota>> getNotasByCurso(@PathVariable Integer idCurso) {
        return ResponseEntity.ok(notaService.findByCurso(idCurso));
    }

    @PostMapping
    public ResponseEntity<Nota> createNota(@RequestBody Nota nota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.create(nota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Integer id, @RequestBody Nota nota) {
        return ResponseEntity.ok(notaService.update(id, nota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Integer id) {
        notaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
