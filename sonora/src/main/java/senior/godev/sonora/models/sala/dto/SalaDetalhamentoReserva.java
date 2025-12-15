package senior.godev.sonora.models.sala.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.reserva.TipoUso;
import senior.godev.sonora.models.sala.Sala;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaDetalhamentoReserva {

    private Sala sala;

    private Boolean emUso;

    private TipoUso tipoUso;
}
