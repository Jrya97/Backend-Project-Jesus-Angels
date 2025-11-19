package com.projectjesusangels.service;

import com.projectjesusangels.entity.Asistencia;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    public List<Asistencia> findAll() {
        return asistenciaRepository.findAll();
    }

    public Asistencia findById(Long id) {
        return asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia", "id", id));
    }

    public List<Asistencia> findByAlumno(Long idAlumno) {
        return asistenciaRepository.findByAlumnoIdAlumno(idAlumno);
    }

    public List<Asistencia> findByFecha(LocalDate fecha) {
        return asistenciaRepository.findByFecha(fecha);
    }

    public List<Asistencia> findByProfesorCurso(Long idProfesorCurso) {
        return asistenciaRepository.findByProfesorCursoIdProfesorCurso(idProfesorCurso);
    }

    public Asistencia create(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public Asistencia update(Long id, Asistencia asistenciaDetails) {
        Asistencia asistencia = findById(id);
        asistencia.setAlumno(asistenciaDetails.getAlumno());
        asistencia.setProfesorCurso(asistenciaDetails.getProfesorCurso());
        asistencia.setFecha(asistenciaDetails.getFecha());
        asistencia.setEstado(asistenciaDetails.getEstado());
        return asistenciaRepository.save(asistencia);
    }

    public void delete(Long id) {
        Asistencia asistencia = findById(id);
        asistenciaRepository.delete(asistencia);
    }
}
