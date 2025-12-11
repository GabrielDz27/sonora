package senior.godev.sonora.models.reserva;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.sala.Sala;

@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
    private Sala paciente;

}
