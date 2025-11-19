package com.projectjesusangels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notas", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_alumno", "id_profesor_curso", "bimestre"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor_curso", nullable = false)
    private ProfesorCurso profesorCurso;

    @Column(name = "bimestre", nullable = false)
    private Integer bimestre;

    @Column(name = "nota", nullable = false, precision = 5, scale = 2)
    private BigDecimal nota;

    @Column(name = "id_usuario_registro", nullable = false)
    private UUID idUsuarioRegistro;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;
}
