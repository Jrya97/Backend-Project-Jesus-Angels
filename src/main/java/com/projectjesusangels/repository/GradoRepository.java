package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Grado;
import com.projectjesusangels.enums.NivelGrado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long> {
    List<Grado> findByNivel(NivelGrado nivel);
}
