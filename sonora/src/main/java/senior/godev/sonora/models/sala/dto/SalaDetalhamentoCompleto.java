package senior.godev.sonora.models.sala.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.sala.Sala;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaDetalhamentoCompleto {

    private Sala sala;

    private String nomes_instrumentos;

    private long count;
}
