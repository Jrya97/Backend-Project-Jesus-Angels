package com.projectjesusangels.service;

import com.projectjesusangels.entity.Apoderado;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.ApoderadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApoderadoService {

    private final ApoderadoRepository apoderadoRepository;

    @Transactional(readOnly = true)
    public List<Apoderado> findAll() {
        return apoderadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Apoderado findById(Integer id) {
        return apoderadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apoderado no encontrado con id: " + id));
    }

    @Transactional(readOnly = true)
    public Apoderado findByDni(String dni) {
        return apoderadoRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("Apoderado no encontrado con DNI: " + dni));
    }

    @Transactional
    public Apoderado save(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    @Transactional
    public Apoderado update(Integer id, Apoderado apoderadoDetails) {
        Apoderado apoderado = findById(id);
        apoderado.setNombre(apoderadoDetails.getNombre());
        apoderado.setApellido(apoderadoDetails.getApellido());
        apoderado.setDni(apoderadoDetails.getDni());
        apoderado.setTelefono(apoderadoDetails.getTelefono());
        apoderado.setEmail(apoderadoDetails.getEmail());
        apoderado.setDireccion(apoderadoDetails.getDireccion());
        return apoderadoRepository.save(apoderado);
    }

    @Transactional
    public void delete(Integer id) {
        Apoderado apoderado = findById(id);
        apoderadoRepository.delete(apoderado);
    }
}
