package senior.godev.sonora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senior.godev.sonora.models.sala.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    Sala findAllById(Long id);
}
