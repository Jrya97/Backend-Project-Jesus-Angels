package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApoderadoRepository extends JpaRepository<Apoderado, Integer> {
    Optional<Apoderado> findByDni(String dni);
}
