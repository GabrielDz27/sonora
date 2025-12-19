package senior.godev.sonora.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.repository.projections.SalaProjection;
import senior.godev.sonora.repository.projections.SalaReservaProjection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    //tras um tipo de detalhamento sobre sala e seus instrumentos que possuim dentro da sala
    @Query(value = """
            SELECT s.*,
            COUNT(i.id) AS quantidadeInstrumentos,
            COALESCE(STRING_AGG(i.nome, ', '), 'Sem instrumento') AS nomesInstrumentos
            FROM salas s
            LEFT JOIN instrumentos i ON i.sala_fixa_id = s.id
            WHERE s.id = :id
            GROUP BY s.id
            """, nativeQuery = true)
    Optional<SalaProjection> findAllAndInstrumentoById(@Param("id") Long id);

    Page<Sala> findAll(Pageable paginacao);

    @Query(value = """
            SELECT
                r.*
            FROM reservas AS r
            INNER JOIN salas as s ON
            s.id = r.sala_id
            where s.id = :id
            """, nativeQuery = true)
    List<Reserva> findAllReservaById(@Param("id") Long id);


    @Query(value = """
            SELECT
                i.*
            FROM instrumentos AS i
            INNER JOIN salas as s ON
            s.id = i.sala_fixa_id
            where s.id = :id
            """, nativeQuery = true
    )
    List<Instrumento> findAllInstrumentoById(@Param("id") Long id);

    Sala findAllById(Long id);

    //Confere se a sala esta em uso ou não, mas trazendo em detalhe geral! vai ser usado no frontend da reserva, quando selecionar a sala
    @Query(value = """
            SELECT
                s.id AS id,
                s.nome AS nome,
                s.capacidade AS capacidade,
                s.tem_abafadores AS temAbafadores,
                (CASE WHEN COUNT(r.id) > 0 THEN TRUE ELSE FALSE END) AS emUso,
                MAX(r.tipo_uso) AS tipoUso
            FROM salas s
            LEFT JOIN reservas r
                ON r.sala_id = s.id
                AND r.motivo_cancelamento IS NULL
                AND r.data_hora_inicio <= :dataHoraFinal
                AND r.data_hora_fim    >= :dataHoraInicio
            GROUP BY s.id, s.nome, s.capacidade, s.tem_abafadores
            """,
            countQuery = """
                        SELECT COUNT(*)
                        FROM salas s
                    """,
            nativeQuery = true)
    Page<SalaReservaProjection> findAllAndReserva(
            Pageable paginacao,
            @Param("dataHoraInicio") LocalDateTime dataHoraInicio,
            @Param("dataHoraFinal") LocalDateTime dataHoraFinal
    );
}
