package senior.godev.sonora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senior.godev.sonora.models.reserva.Reserva;

import java.time.LocalDateTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(value = """
            SELECT 
            CASE (r.data_hora_inicio BETWEEN :dataHoraInicio AND :dataHoraFim
                AND r.data_hora_fim BETWEEN :dataHoraInicio AND :dataHoraFim
                AND r.motivo_cancelamento IS NOT NULL
                AND r.tipo_uso NOT IN ('ENSAIO_BANDA', 'ENSAIO_ORQUESTRA', 'ESTUDO_GRUPO')
                ) THEN TRUE
                ELSE FALSE
            END AS em_uso
            FROM reservas r
            ORDER BY em_uso 
            LIMIT 1 
            """, nativeQuery = true)
    boolean existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(
            @Param("dataHoraInicio") LocalDateTime dataHoraInicio,
            @Param("dataHoraFim") LocalDateTime dataHoraFim);
}
