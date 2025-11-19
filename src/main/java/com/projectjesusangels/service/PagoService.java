package com.projectjesusangels.service;

import com.projectjesusangels.entity.Pago;
import com.projectjesusangels.enums.EstadoPago;
import com.projectjesusangels.enums.TipoPago;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PagoService {

    private final PagoRepository pagoRepository;

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago findById(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago", "id", id));
    }

    public List<Pago> findByMatricula(Long idMatricula) {
        return pagoRepository.findByMatriculaIdMatricula(idMatricula);
    }

    public List<Pago> findByEstado(EstadoPago estado) {
        return pagoRepository.findByEstado(estado);
    }

    public List<Pago> findByTipo(TipoPago tipo) {
        return pagoRepository.findByTipo(tipo);
    }

    public Pago create(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago update(Long id, Pago pagoDetails) {
        Pago pago = findById(id);
        pago.setMatricula(pagoDetails.getMatricula());
        pago.setTipo(pagoDetails.getTipo());
        pago.setMes(pagoDetails.getMes());
        pago.setMonto(pagoDetails.getMonto());
        pago.setFechaPago(pagoDetails.getFechaPago());
        pago.setEstado(pagoDetails.getEstado());
        return pagoRepository.save(pago);
    }

    public void delete(Long id) {
        Pago pago = findById(id);
        pagoRepository.delete(pago);
    }
}
