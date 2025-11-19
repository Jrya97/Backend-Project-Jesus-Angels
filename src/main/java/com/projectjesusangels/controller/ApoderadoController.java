package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Apoderado;
import com.projectjesusangels.service.ApoderadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apoderados")
@RequiredArgsConstructor
public class ApoderadoController {

    private final ApoderadoService apoderadoService;

    @GetMapping
    public ResponseEntity<List<Apoderado>> getAllApoderados() {
        return ResponseEntity.ok(apoderadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apoderado> getApoderadoById(@PathVariable Integer id) {
        return ResponseEntity.ok(apoderadoService.findById(id));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Apoderado> getApoderadoByDni(@PathVariable String dni) {
        return ResponseEntity.ok(apoderadoService.findByDni(dni));
    }

    @PostMapping
    public ResponseEntity<Apoderado> createApoderado(@RequestBody Apoderado apoderado) {
        return new ResponseEntity<>(apoderadoService.save(apoderado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apoderado> updateApoderado(@PathVariable Integer id, @RequestBody Apoderado apoderado) {
        return ResponseEntity.ok(apoderadoService.update(id, apoderado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApoderado(@PathVariable Integer id) {
        apoderadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
