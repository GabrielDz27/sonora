package senior.godev.sonora.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.reserva.Reserva;

import java.util.List;
import java.util.Optional;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {
    Instrumento findAllById(Long nome);

    Page<Instrumento> findAll(Pageable pageable);

    Optional<Instrumento> findById(Long id);

    @Query(value = """
            SELECT
                r.*
            FROM reservas AS r
            INNER JOIN Instrumento as i ON
            i.id = r.sala_id
            where i.id = :id
            """, nativeQuery = true)
    List<Reserva> findAllReservaById(@Param("id") Long id);
}
