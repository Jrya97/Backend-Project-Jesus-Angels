package com.projectjesusangels.service;

import com.projectjesusangels.entity.Perfil;
import com.projectjesusangels.enums.RolUsuario;
import com.projectjesusangels.exception.ResourceNotFoundException;
import com.projectjesusangels.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository perfilRepository;

    @Transactional(readOnly = true)
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Perfil findById(UUID id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil no encontrado con id: " + id));
    }

    @Transactional(readOnly = true)
    public List<Perfil> findByRol(RolUsuario rol) {
        return perfilRepository.findByRol(rol);
    }

    @Transactional
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Transactional
    public Perfil update(UUID id, Perfil perfilDetails) {
        Perfil perfil = findById(id);
        perfil.setNombre(perfilDetails.getNombre());
        perfil.setRol(perfilDetails.getRol());
        perfil.setUsuario(perfilDetails.getUsuario());
        perfil.setPassword(perfilDetails.getPassword());
        return perfilRepository.save(perfil);
    }

    @Transactional
    public void delete(UUID id) {
        Perfil perfil = findById(id);
        perfilRepository.delete(perfil);
    }
}
