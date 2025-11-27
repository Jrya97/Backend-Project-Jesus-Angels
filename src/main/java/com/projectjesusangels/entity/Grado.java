package com.projectjesusangels.entity;

import com.projectjesusangels.enums.NivelGrado;
import com.projectjesusangels.enums.NombreGrado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grados", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre", "nivel"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grado")
    private Integer idGrado;

    @Convert(converter = com.projectjesusangels.converter.NombreGradoConverter.class)
    @Column(name = "nombre", nullable = false)
    private NombreGrado nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", nullable = false)
    private NivelGrado nivel;
}
