package com.projectjesusangels.repository;

import com.projectjesusangels.entity.AlumnoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoCursoRepository extends JpaRepository<AlumnoCurso, Integer> {
    List<AlumnoCurso> findByAlumnoIdAlumno(Integer idAlumno);
}
