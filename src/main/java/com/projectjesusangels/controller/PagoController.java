package com.projectjesusangels.controller;

import com.projectjesusangels.entity.Pago;
import com.projectjesusangels.enums.EstadoPago;
import com.projectjesusangels.enums.TipoPago;
import com.projectjesusangels.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Integer id) {
        return ResponseEntity.ok(pagoService.findById(id));
    }

    @GetMapping("/matricula/{idMatricula}")
    public ResponseEntity<List<Pago>> getPagosByMatricula(@PathVariable Integer idMatricula) {
        return ResponseEntity.ok(pagoService.findByMatricula(idMatricula));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pago>> getPagosByEstado(@PathVariable EstadoPago estado) {
        return ResponseEntity.ok(pagoService.findByEstado(estado));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Pago>> getPagosByTipo(@PathVariable TipoPago tipo) {
        return ResponseEntity.ok(pagoService.findByTipo(tipo));
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.create(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable Integer id, @RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.update(id, pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Integer id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
