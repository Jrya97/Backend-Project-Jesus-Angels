package com.projectjesusangels.service;

import com.projectjesusangels.entity.Grado;
import com.projectjesusangels.enums.NivelGrado;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.GradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradoService {

    private final GradoRepository gradoRepository;

    @Transactional(readOnly = true)
    public List<Grado> findAll() {
        return gradoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Grado findById(Integer id) {
        return gradoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grado no encontrado con id: " + id));
    }

    @Transactional(readOnly = true)
    public List<Grado> findByNivel(NivelGrado nivel) {
        return gradoRepository.findByNivel(nivel);
    }

    @Transactional
    public Grado save(Grado grado) {
        return gradoRepository.save(grado);
    }

    @Transactional
    public Grado update(Integer id, Grado gradoDetails) {
        Grado grado = findById(id);
        grado.setNombre(gradoDetails.getNombre());
        grado.setNivel(gradoDetails.getNivel());
        return gradoRepository.save(grado);
    }

    @Transactional
    public void delete(Integer id) {
        Grado grado = findById(id);
        gradoRepository.delete(grado);
    }
}
