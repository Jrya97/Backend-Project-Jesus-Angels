package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    Optional<Alumno> findByDni(String dni);
    List<Alumno> findByApoderadoIdApoderado(Integer idApoderado);
}
