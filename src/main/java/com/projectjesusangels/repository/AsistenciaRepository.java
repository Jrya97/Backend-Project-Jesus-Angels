package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByAlumnoIdAlumno(Long idAlumno);
    List<Asistencia> findByFecha(LocalDate fecha);
    List<Asistencia> findByProfesorCursoIdProfesorCurso(Long idProfesorCurso);
}
