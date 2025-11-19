package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Grado;
import com.projectjesusangels.enums.NivelGrado;
import com.projectjesusangels.service.GradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grados")
@RequiredArgsConstructor
public class GradoController {

    private final GradoService gradoService;

    @GetMapping
    public ResponseEntity<List<Grado>> getAllGrados() {
        return ResponseEntity.ok(gradoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grado> getGradoById(@PathVariable Integer id) {
        return ResponseEntity.ok(gradoService.findById(id));
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<Grado>> getGradosByNivel(@PathVariable NivelGrado nivel) {
        return ResponseEntity.ok(gradoService.findByNivel(nivel));
    }

    @PostMapping
    public ResponseEntity<Grado> createGrado(@RequestBody Grado grado) {
        return new ResponseEntity<>(gradoService.save(grado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grado> updateGrado(@PathVariable Integer id, @RequestBody Grado grado) {
        return ResponseEntity.ok(gradoService.update(id, grado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrado(@PathVariable Integer id) {
        gradoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
