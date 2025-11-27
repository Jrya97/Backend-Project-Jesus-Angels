package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Asistencia;
import com.projectjesusangels.service.AsistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
@RequiredArgsConstructor
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    @GetMapping
    public ResponseEntity<List<Asistencia>> getAllAsistencias() {
        return ResponseEntity.ok(asistenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable Integer id) {
        return ResponseEntity.ok(asistenciaService.findById(id));
    }

    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<Asistencia>> getAsistenciasByAlumno(@PathVariable Integer idAlumno) {
        return ResponseEntity.ok(asistenciaService.findByAlumno(idAlumno));
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Asistencia>> getAsistenciasByFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(asistenciaService.findByFecha(fecha));
    }

    @GetMapping("/profesor-curso/{idProfesorCurso}")
    public ResponseEntity<List<Asistencia>> getAsistenciasByProfesorCurso(@PathVariable Integer idProfesorCurso) {
        return ResponseEntity.ok(asistenciaService.findByProfesorCurso(idProfesorCurso));
    }

    @PostMapping
    public ResponseEntity<Asistencia> createAsistencia(@RequestBody Asistencia asistencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenciaService.create(asistencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> updateAsistencia(@PathVariable Integer id, @RequestBody Asistencia asistencia) {
        return ResponseEntity.ok(asistenciaService.update(id, asistencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable Integer id) {
        asistenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
