package com.projectjesusangels.entity;

import com.projectjesusangels.enums.EstadoAsistencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "asistencia", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_alumno", "id_profesor_curso", "fecha"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long idAsistencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor_curso", nullable = false)
    private ProfesorCurso profesorCurso;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoAsistencia estado = EstadoAsistencia.AUSENTE;
}
