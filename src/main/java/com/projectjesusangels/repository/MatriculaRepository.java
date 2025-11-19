package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Matricula;
import com.projectjesusangels.enums.EstadoMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByAlumnoIdAlumno(Long idAlumno);
    List<Matricula> findByGradoIdGrado(Long idGrado);
    List<Matricula> findByAnioLectivo(Integer anioLectivo);
    List<Matricula> findByEstado(EstadoMatricula estado);
}
