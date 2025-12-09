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

    public Asistencia findById(Integer id) {
        return asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia", "id", id));
    }

    public List<Asistencia> findByAlumno(Integer idAlumno) {
        return asistenciaRepository.findByAlumnoIdAlumno(idAlumno);
    }

    public List<Asistencia> findByFecha(LocalDate fecha) {
        return asistenciaRepository.findByFecha(fecha);
    }


    public Asistencia create(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public Asistencia partialUpdate(Integer id, Asistencia asistenciaDetails) {
        Asistencia asistencia = findById(id);
        
        // Solo actualizar los campos que no son null
        if (asistenciaDetails.getAlumno() != null) {
            asistencia.setAlumno(asistenciaDetails.getAlumno());
        }
        if (asistenciaDetails.getFecha() != null) {
            asistencia.setFecha(asistenciaDetails.getFecha());
        }
        if (asistenciaDetails.getEstado() != null) {
            asistencia.setEstado(asistenciaDetails.getEstado());
        }
        
        return asistenciaRepository.save(asistencia);
    }

    public List<Asistencia> createBatch(List<Asistencia> asistencias) {
        return asistenciaRepository.saveAll(asistencias);
    }

    public Asistencia update(Integer id, Asistencia asistenciaDetails) {
        Asistencia asistencia = findById(id);
        asistencia.setAlumno(asistenciaDetails.getAlumno());
        asistencia.setFecha(asistenciaDetails.getFecha());
        asistencia.setEstado(asistenciaDetails.getEstado());
        return asistenciaRepository.save(asistencia);
    }

    public void delete(Integer id) {
        Asistencia asistencia = findById(id);
        asistenciaRepository.delete(asistencia);
    }
}
