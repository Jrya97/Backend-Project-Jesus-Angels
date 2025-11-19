package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Matricula;
import com.projectjesusangels.enums.EstadoMatricula;
import com.projectjesusangels.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> getAllMatriculas() {
        return ResponseEntity.ok(matriculaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getMatriculaById(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.findById(id));
    }

    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<Matricula>> getMatriculasByAlumno(@PathVariable Long idAlumno) {
        return ResponseEntity.ok(matriculaService.findByAlumno(idAlumno));
    }

    @GetMapping("/grado/{idGrado}")
    public ResponseEntity<List<Matricula>> getMatriculasByGrado(@PathVariable Long idGrado) {
        return ResponseEntity.ok(matriculaService.findByGrado(idGrado));
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<Matricula>> getMatriculasByAnio(@PathVariable Integer anio) {
        return ResponseEntity.ok(matriculaService.findByAnio(anio));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Matricula>> getMatriculasByEstado(@PathVariable EstadoMatricula estado) {
        return ResponseEntity.ok(matriculaService.findByEstado(estado));
    }

    @PostMapping
    public ResponseEntity<Matricula> createMatricula(@RequestBody Matricula matricula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.create(matricula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> updateMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.update(id, matricula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatricula(@PathVariable Long id) {
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
