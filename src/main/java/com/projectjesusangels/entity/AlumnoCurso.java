package com.projectjesusangels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno_curso", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_alumno", "id_profesor_curso"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno_curso")
    private Long idAlumnoCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor_curso", nullable = false)
    private ProfesorCurso profesorCurso;
}
