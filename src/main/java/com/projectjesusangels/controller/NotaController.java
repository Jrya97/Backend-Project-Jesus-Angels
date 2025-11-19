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
    public ResponseEntity<Nota> getNotaById(@PathVariable Long id) {
        return ResponseEntity.ok(notaService.findById(id));
    }

    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<Nota>> getNotasByAlumno(@PathVariable Long idAlumno) {
        return ResponseEntity.ok(notaService.findByAlumno(idAlumno));
    }

    @GetMapping("/bimestre/{bimestre}")
    public ResponseEntity<List<Nota>> getNotasByBimestre(@PathVariable Integer bimestre) {
        return ResponseEntity.ok(notaService.findByBimestre(bimestre));
    }

    @GetMapping("/profesor-curso/{idProfesorCurso}")
    public ResponseEntity<List<Nota>> getNotasByProfesorCurso(@PathVariable Long idProfesorCurso) {
        return ResponseEntity.ok(notaService.findByProfesorCurso(idProfesorCurso));
    }

    @PostMapping
    public ResponseEntity<Nota> createNota(@RequestBody Nota nota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.create(nota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Long id, @RequestBody Nota nota) {
        return ResponseEntity.ok(notaService.update(id, nota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        notaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
