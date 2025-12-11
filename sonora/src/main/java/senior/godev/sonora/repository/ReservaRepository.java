package senior.godev.sonora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senior.godev.sonora.models.reserva.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
