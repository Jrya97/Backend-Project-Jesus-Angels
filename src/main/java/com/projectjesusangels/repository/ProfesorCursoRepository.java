package com.projectjesusangels.repository;

import com.projectjesusangels.entity.ProfesorCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProfesorCursoRepository extends JpaRepository<ProfesorCurso, Integer> {
    List<ProfesorCurso> findByPerfilId(UUID idProfesor);
    List<ProfesorCurso> findByCursoIdCurso(Integer idCurso);
    List<ProfesorCurso> findByGradoIdGrado(Integer idGrado);
}
