package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Perfil;
import com.projectjesusangels.enums.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, UUID> {
    List<Perfil> findByRol(RolUsuario rol);
}
