package com.projectjesusangels.entity;

import com.projectjesusangels.enums.EstadoMatricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_alumno", "id_grado", "anio_lectivo"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grado", nullable = false)
    private Grado grado;

    @Column(name = "anio_lectivo", nullable = false)
    private Integer anioLectivo;

    @Column(name = "fecha_matricula", nullable = false)
    private LocalDate fechaMatricula = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoMatricula estado = EstadoMatricula.ACTIVO;
}
