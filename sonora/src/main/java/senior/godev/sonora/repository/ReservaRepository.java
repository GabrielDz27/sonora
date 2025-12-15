package senior.godev.sonora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import senior.godev.sonora.models.reserva.Reserva;

import java.time.LocalDateTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("""
            SELECT 
            CASE (r.data_hora_inicio BETWEEN :dataHoraInicio AND :dataHoraFim
                AND r.data_hora_fim BETWEEN :dataHoraInicio AND :dataHoraFim
                AND r.motivo_cancelamento IS NOT NULL
                AND r.tipo_uso NOT IN ('ENSAIO_BANDA', 'ENSAIO_ORQUESTRA', 'ESTUDO_GRUPO')
                ) THEN TRUE
                ELSE FALSE
            END 
            FROM reservas r 
            """)
    boolean existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);
}
