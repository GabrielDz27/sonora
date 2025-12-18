package senior.godev.sonora.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senior.godev.sonora.models.reserva.Reserva;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Page<Reserva> findAll(Pageable pageable);

    //Sala: Vai dizer se esta em uso a sala,
    @Query(value = """
            SELECT
                CASE 
                    WHEN (r.data_hora_inicio BETWEEN :dataHoraInicio AND :dataHoraFim
                    AND r.data_hora_fim BETWEEN :dataHoraInicio AND :dataHoraFim
                    AND r.motivo_cancelamento IS NOT NULL
                    AND r.motivo_cancelamento NOT IN ('NAO_CONFIRMACAO_TEMPO')
                    AND r.tipo_uso NOT IN ('ENSAIO_BANDA', 'ENSAIO_ORQUESTRA', 'ESTUDO_GRUPO')
                    ) THEN TRUE
                    ELSE FALSE
                END AS em_uso
            FROM reservas r
            ORDER BY em_uso 
            LIMIT 1 
            """, nativeQuery = true)
    Boolean existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(
            @Param("dataHoraInicio") LocalDateTime dataHoraInicio,
            @Param("dataHoraFim") LocalDateTime dataHoraFim);

    //Membro: Vai validar se tem sala no mesmo horario e que membro ja possui na marcação, isso se a sala for diferente
    @Query(value = """
            SELECT
                CASE 
                    WHEN (r.data_hora_inicio BETWEEN :dataHoraInicio AND :dataHoraFinal
                        AND r.data_hora_fim BETWEEN :dataHoraInicio AND :dataHoraFinal
                        AND r.motivo_cancelamento IS NOT NULL
                        AND r.sala_id <> :idSala
                    ) THEN TRUE
                    ELSE FALSE
                END AS em_uso
            FROM reservas r
            INNER JOIN membros m ON m.id = r.membro_id
            WHERE r.membro_id = :idMembro
            ORDER BY em_uso
            LIMIT 1
            """, nativeQuery = true)
    Boolean existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNullAndIdMembroAndIdSala(
            @Param("dataHoraInicio") LocalDateTime dataHoraInicio,
            @Param("dataHoraFinal") LocalDateTime dataHoraFinal,
            @Param("idMembro") Long idMembro,
            @Param("idSala") Long idSala
    );

    Reserva findAllById(Long id);

    @Query(value = """
            SELECT
                r.id AS id,
                r.membro_id,
                r.instrumento_id,
                r.sala_id,
                r.data_hora_inicio AS dataHoraInicio,
                r.data_hora_fim AS dataHoraFim,
                r.data_hora_registro AS dataHoraRegistro,
                r.em_espera AS emEspera,
                r.motivo_cancelamento,
                r.tipo_uso AS tipoUso,
                r.observacoes
            FROM reservas r
            WHERE DATE r.data_hora_inicio = DATE :agora
            """, nativeQuery = true)
    List<Reserva> findAllbyDataHoraInicio(@Param("agora") LocalDateTime agora);

    @Query(value = """
            SELECT
                r.*
            FROM reservas r
            WHERE r.data_hora_inicio <= :limiteSuperior
              AND r.data_hora_inicio > NOW()
              AND r.motivo_cancelamento = 'PENDENTE_CONFIRMACAO'
            """, nativeQuery = true)
    List<Reserva> findAllReservasPendentesVencendo(@Param("limiteSuperior") LocalDateTime limiteSuperior);

    @Query(value = """
            SELECT
                r.*
            FROM reservas r
            WHERE r.sala_id = :salaId
              AND r.data_hora_inicio = :dataHoraInicio
              AND r.em_espera = TRUE
            ORDER BY r.data_hora_registro ASC
            LIMIT 1
            """, nativeQuery = true)
    Optional<Reserva> findProximoEmEspera(
            @Param("salaId") Long salaId,
            @Param("dataHoraInicio") LocalDateTime dataHoraInicio
    );
}
