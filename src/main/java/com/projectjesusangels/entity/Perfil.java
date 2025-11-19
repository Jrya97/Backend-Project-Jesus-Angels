package com.projectjesusangels.entity;

import com.projectjesusangels.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "perfiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private RolUsuario rol = RolUsuario.PROFESOR;

    @CreationTimestamp
    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creadoEn;
}
