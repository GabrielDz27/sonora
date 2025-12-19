package senior.godev.sonora.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.repository.projections.InstrumentoReservaProjection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {
    Instrumento findAllById(Long id);

    Page<Instrumento> findAll(Pageable pageable);

    Optional<Instrumento> findById(Long id);

    //Vai ser usado pra pegar todas as reservas de instrumentos antes de fazer o DELETE do instrumento.
    // Assim flegando o attributo instrumento da reserva com NULL;
    @Query(value = """
            SELECT
                r.*
            FROM reservas AS r
            INNER JOIN Instrumentos as i ON
            i.id = r.instrumento_id
            where i.id = :id
            """, nativeQuery = true)
    List<Reserva> findAllReservaById(@Param("id") Long id);

    //Buscar todos instrumentos, aqueles que estão sendo reservados e não, tratando isso no front para aparecer.
    @Query(value = """
            SELECT
                i.id AS idInstrumento,
                i.nome AS nome,
                i.modelo AS modelo,
                MAX(r.sala_id) AS idSala,
                (CASE WHEN COUNT(r.id) > 0 THEN TRUE ELSE FALSE END) AS emUso,
                MAX(r.tipo_uso) AS tipoUso
            FROM instrumentos i
            LEFT JOIN reservas r
                ON r.instrumento_id = i.id
                AND r.motivo_cancelamento IS NULL
                AND r.data_hora_inicio <= :dataHoraFinal
                AND r.data_hora_fim    >= :dataHoraInicio
            GROUP BY i.id, i.nome, i.modelo
            """,
            countQuery = """
                        SELECT COUNT(*)
                        FROM instrumentos i
                    """,
            nativeQuery = true)
    Page<InstrumentoReservaProjection> findAllAndReserva(
            Pageable paginacao,
            @Param("dataHoraInicio") LocalDateTime dataHoraInicio,
            @Param("dataHoraFinal") LocalDateTime dataHoraFinal
    );

    //E uma validação na reseva pra dizer se o instrmento selecionado está reservado ou não
    @Query(value = """
            SELECT
                CASE
                    WHEN r.data_hora_inicio <= :dataHoraFinal
                        AND r.data_hora_fim >= :dataHoraInicio
                        AND r.motivo_cancelamento IS NULL
                    THEN TRUE ELSE FALSE
                END AS emUso
            FROM reservas r
            WHERE r.instrumento_id = :id
            ORDER BY emUso
            LIMIT 1
            """,
            nativeQuery = true)
    Boolean instrumentoReservado(@Param("id") Long id,
                                 @Param("dataHoraInicio") LocalDateTime dataHoraInicio,
                                 @Param("dataHoraFinal") LocalDateTime dataHoraFinal);
}
