package senior.godev.sonora.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.repository.projections.SalaProjection;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
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
}
