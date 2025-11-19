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

    public Nota findById(Long id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nota", "id", id));
    }

    public List<Nota> findByAlumno(Long idAlumno) {
        return notaRepository.findByAlumnoIdAlumno(idAlumno);
    }

    public List<Nota> findByBimestre(Integer bimestre) {
        return notaRepository.findByBimestre(bimestre);
    }

    public List<Nota> findByProfesorCurso(Long idProfesorCurso) {
        return notaRepository.findByProfesorCursoIdProfesorCurso(idProfesorCurso);
    }

    public Nota create(Nota nota) {
        // Validate nota is between 0 and 20
        if (nota.getNota().compareTo(java.math.BigDecimal.ZERO) < 0 || 
            nota.getNota().compareTo(new java.math.BigDecimal("20")) > 0) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 20");
        }
        // Validate bimestre is between 1 and 4
        if (nota.getBimestre() < 1 || nota.getBimestre() > 4) {
            throw new IllegalArgumentException("El bimestre debe estar entre 1 y 4");
        }
        return notaRepository.save(nota);
    }

    public Nota update(Long id, Nota notaDetails) {
        Nota nota = findById(id);
        // Validate nota is between 0 and 20
        if (notaDetails.getNota().compareTo(java.math.BigDecimal.ZERO) < 0 || 
            notaDetails.getNota().compareTo(new java.math.BigDecimal("20")) > 0) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 20");
        }
        nota.setAlumno(notaDetails.getAlumno());
        nota.setProfesorCurso(notaDetails.getProfesorCurso());
        nota.setBimestre(notaDetails.getBimestre());
        nota.setNota(notaDetails.getNota());
        nota.setIdUsuarioRegistro(notaDetails.getIdUsuarioRegistro());
        return notaRepository.save(nota);
    }

    public void delete(Long id) {
        Nota nota = findById(id);
        notaRepository.delete(nota);
    }
}
