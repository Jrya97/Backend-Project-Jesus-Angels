package com.projectjesusangels.entity;

import com.projectjesusangels.enums.EstadoPago;
import com.projectjesusangels.enums.MesPago;
import com.projectjesusangels.enums.TipoPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_alumno", "tipo", "mes"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", nullable = false)
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Alumno alumno;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoPago tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "mes")
    private MesPago mes;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPago estado = EstadoPago.PENDIENTE;
}
