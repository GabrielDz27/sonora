package senior.godev.sonora.models.sala;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.reserva.Reserva;

import java.util.List;

@Entity
@Table(name = "salas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int capacidade;

    private Boolean tem_abafadores;


    @OneToMany(mappedBy = "salas", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Reserva> reservas;

    public Sala(DadosCadastroSala dadosCadastroSala) {
        this.capacidade = dadosCadastroSala.capacidade();
        this.nome = dadosCadastroSala.nome();
        this.tem_abafadores = dadosCadastroSala.tem_abafadores();
    }

    public void atualizarSala(DadosAtualizacaoSala dadosAtualizacaoSala) {
        if (dadosAtualizacaoSala.nome() != null) {
            this.nome = dadosAtualizacaoSala.nome();
        }

        if (dadosAtualizacaoSala.tem_abafadores() != null) {
            this.tem_abafadores = dadosAtualizacaoSala.tem_abafadores();
        }

        if (dadosAtualizacaoSala.capacidade() > 0) {
            this.capacidade = dadosAtualizacaoSala.capacidade();
        }
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.setPaciente(null);
    }

}
