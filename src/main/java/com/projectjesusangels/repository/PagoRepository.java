package com.projectjesusangels.repository;

import com.projectjesusangels.entity.Pago;
import com.projectjesusangels.enums.EstadoPago;
import com.projectjesusangels.enums.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByMatriculaIdMatricula(Integer idMatricula);
    List<Pago> findByEstado(EstadoPago estado);
    List<Pago> findByTipo(TipoPago tipo);
}
