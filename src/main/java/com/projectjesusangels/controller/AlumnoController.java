package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Alumno;
import com.projectjesusangels.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.findById(id));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Alumno> getAlumnoByDni(@PathVariable String dni) {
        return ResponseEntity.ok(alumnoService.findByDni(dni));
    }

    @GetMapping("/apoderado/{idApoderado}")
    public ResponseEntity<List<Alumno>> getAlumnosByApoderado(@PathVariable Long idApoderado) {
        return ResponseEntity.ok(alumnoService.findByApoderado(idApoderado));
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.create(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.update(id, alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
