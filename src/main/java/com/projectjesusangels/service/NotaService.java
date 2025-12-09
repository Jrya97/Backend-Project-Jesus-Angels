package com.projectjesusangels.service;

import com.projectjesusangels.entity.Nota;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NotaService {

    private final NotaRepository notaRepository;

    public List<Nota> findAll() {
        return notaRepository.findAll();
    }

    public Nota findById(Integer id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota", "id", id));
    }

    public List<Nota> findByAlumno(Integer idAlumno) {
        return notaRepository.findByAlumnoIdAlumno(idAlumno);
    }

    public List<Nota> findByTipoNota(String tipoNota) {
        return notaRepository.findByTipoNota(tipoNota);
    }

    public List<Nota> findByCurso(Integer idCurso) {
        return notaRepository.findByCursoIdCurso(idCurso);
    }

    public Nota create(Nota nota) {
        // Validate nota is between 0 and 20
        if (nota.getNota().compareTo(java.math.BigDecimal.ZERO) < 0 || 
            nota.getNota().compareTo(new java.math.BigDecimal("20")) > 0) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 20");
        }
        // Validate tipoNota is not empty
        if (nota.getTipoNota() == null || nota.getTipoNota().trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de nota es requerido");
        }
        return notaRepository.save(nota);
    }

    public Nota update(Integer id, Nota notaDetails) {
        Nota nota = findById(id);
        // Validate nota is between 0 and 20
        if (notaDetails.getNota().compareTo(java.math.BigDecimal.ZERO) < 0 || 
            notaDetails.getNota().compareTo(new java.math.BigDecimal("20")) > 0) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 20");
        }
        nota.setAlumno(notaDetails.getAlumno());
        nota.setCurso(notaDetails.getCurso());
        nota.setTipoNota(notaDetails.getTipoNota());
        nota.setNota(notaDetails.getNota());
        nota.setIdUsuarioRegistro(notaDetails.getIdUsuarioRegistro());
        return notaRepository.save(nota);
    }

    public void delete(Integer id) {
        Nota nota = findById(id);
        notaRepository.delete(nota);
    }
}
