package com.projectjesusangels.repository;

import com.projectjesusangels.entity.ProfesorCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProfesorCursoRepository extends JpaRepository<ProfesorCurso, Long> {
    List<ProfesorCurso> findByPerfilId(UUID idProfesor);
    List<ProfesorCurso> findByCursoIdCurso(Long idCurso);
    List<ProfesorCurso> findByGradoIdGrado(Long idGrado);
}
