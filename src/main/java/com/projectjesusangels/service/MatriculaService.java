package com.projectjesusangels.service;

import com.projectjesusangels.entity.Matricula;
import com.projectjesusangels.enums.EstadoMatricula;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    public Matricula findById(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula", "id", id));
    }

    public List<Matricula> findByAlumno(Long idAlumno) {
        return matriculaRepository.findByAlumnoIdAlumno(idAlumno);
    }

    public List<Matricula> findByGrado(Long idGrado) {
        return matriculaRepository.findByGradoIdGrado(idGrado);
    }

    public List<Matricula> findByAnio(Integer anio) {
        return matriculaRepository.findByAnioLectivo(anio);
    }

    public List<Matricula> findByEstado(EstadoMatricula estado) {
        return matriculaRepository.findByEstado(estado);
    }

    public Matricula create(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public Matricula update(Long id, Matricula matriculaDetails) {
        Matricula matricula = findById(id);
        matricula.setAlumno(matriculaDetails.getAlumno());
        matricula.setGrado(matriculaDetails.getGrado());
        matricula.setAnioLectivo(matriculaDetails.getAnioLectivo());
        matricula.setFechaMatricula(matriculaDetails.getFechaMatricula());
        matricula.setEstado(matriculaDetails.getEstado());
        return matriculaRepository.save(matricula);
    }

    public void delete(Long id) {
        Matricula matricula = findById(id);
        matriculaRepository.delete(matricula);
    }
}
