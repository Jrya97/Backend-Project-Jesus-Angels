package com.projectjesusangels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "profesor_curso", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_usuario", "id_curso", "id_grado"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor_curso")
    private Long idProfesorCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grado", nullable = false)
    private Grado grado;
}
