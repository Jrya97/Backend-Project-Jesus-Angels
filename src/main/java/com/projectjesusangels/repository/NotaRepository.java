package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlumnoIdAlumno(Long idAlumno);
    List<Nota> findByBimestre(Integer bimestre);
    List<Nota> findByProfesorCursoIdProfesorCurso(Long idProfesorCurso);
}
