package senior.godev.sonora.models.sala;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.dto.DadosAtualizacaoSala;
import senior.godev.sonora.models.sala.dto.DadosCadastroSala;

import java.util.List;

@Entity
@Table(name = "salas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int capacidade;

    private Boolean temAbafadores;

    @OneToMany(mappedBy = "sala_fixa_id", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Instrumento> instrumentos;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Reserva> reservas;

    public Sala(DadosCadastroSala dadosCadastroSala) {
        this.capacidade = dadosCadastroSala.capacidade();
        this.nome = dadosCadastroSala.nome();
        this.temAbafadores = dadosCadastroSala.temAbafadores();
    }

    public void atualizarSala(DadosAtualizacaoSala dadosAtualizacaoSala) {
        if (dadosAtualizacaoSala.nome() != null) {
            this.nome = dadosAtualizacaoSala.nome();
        }

        if (dadosAtualizacaoSala.temAbafadores() != null) {
            this.temAbafadores = dadosAtualizacaoSala.temAbafadores();
        }

        if (dadosAtualizacaoSala.capacidade() > 0) {
            this.capacidade = dadosAtualizacaoSala.capacidade();
        }
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.setSala(null);
    }

    public void removerInstrumento(Instrumento instrumento) {
        instrumentos.remove(instrumento);
        instrumento.setId(null);
    }
}
