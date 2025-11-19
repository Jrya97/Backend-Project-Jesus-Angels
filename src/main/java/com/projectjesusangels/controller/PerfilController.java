package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Perfil;
import com.projectjesusangels.enums.RolUsuario;
import com.projectjesusangels.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Perfil>> getAllPerfiles() {
        return ResponseEntity.ok(perfilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable UUID id) {
        return ResponseEntity.ok(perfilService.findById(id));
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Perfil>> getPerfilesByRol(@PathVariable RolUsuario rol) {
        return ResponseEntity.ok(perfilService.findByRol(rol));
    }

    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil) {
        return new ResponseEntity<>(perfilService.save(perfil), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable UUID id, @RequestBody Perfil perfil) {
        return ResponseEntity.ok(perfilService.update(id, perfil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable UUID id) {
        perfilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
