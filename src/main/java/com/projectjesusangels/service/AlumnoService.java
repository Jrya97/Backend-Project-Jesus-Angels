package com.projectjesusangels.service;

import com.projectjesusangels.entity.Alumno;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno", "id", id));
    }

    public Alumno findByDni(String dni) {
        return alumnoRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno", "dni", dni));
    }

    public List<Alumno> findByApoderado(Long idApoderado) {
        return alumnoRepository.findByApoderadoIdApoderado(idApoderado);
    }

    public Alumno create(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno update(Long id, Alumno alumnoDetails) {
        Alumno alumno = findById(id);
        alumno.setNombre(alumnoDetails.getNombre());
        alumno.setApellido(alumnoDetails.getApellido());
        alumno.setDni(alumnoDetails.getDni());
        alumno.setFechaNacimiento(alumnoDetails.getFechaNacimiento());
        alumno.setDireccion(alumnoDetails.getDireccion());
        alumno.setApoderado(alumnoDetails.getApoderado());
        return alumnoRepository.save(alumno);
    }

    public void delete(Long id) {
        Alumno alumno = findById(id);
        alumnoRepository.delete(alumno);
    }
}
