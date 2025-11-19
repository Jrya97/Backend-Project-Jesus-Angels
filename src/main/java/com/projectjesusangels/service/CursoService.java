package com.projectjesusangels.service;

import com.projectjesusangels.entity.Curso;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso", "id", id));
    }

    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso update(Long id, Curso cursoDetails) {
        Curso curso = findById(id);
        curso.setNombre(cursoDetails.getNombre());
        return cursoRepository.save(curso);
    }

    public void delete(Long id) {
        Curso curso = findById(id);
        cursoRepository.delete(curso);
    }
}
