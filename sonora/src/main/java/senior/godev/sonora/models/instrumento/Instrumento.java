package senior.godev.sonora.models.instrumento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.instrumento.dto.DadosAtualizacaoInstrumento;
import senior.godev.sonora.models.instrumento.dto.DadosCadastroInstrumento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;

import java.util.List;

@Entity
@Table(name = "instrumentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_instrumento")
    @Enumerated(EnumType.STRING)
    private TipoInstrumento tipoInstrumento;

    private String nome;

    private String modelo;

    private String numeroSerie;

    private int anoFabricacao;

    private String paisOrigem;

    private String estadoConservacao;

    private String caracteristica;

    @ManyToOne
    @JoinColumn(name = "sala_fixa_id")
    private Sala sala_fixa_id;

    @OneToMany(mappedBy = "instrumento")
    private List<Reserva> reservas;

    public Instrumento(DadosCadastroInstrumento dados, Sala sala) {
        this.nome = dados.nome();
        this.tipoInstrumento = dados.tipoInstrumento();
        this.modelo = dados.modelo();
        this.numeroSerie = dados.numeroSerie();
        this.anoFabricacao = dados.anoFabricacao();
        this.paisOrigem = dados.paisOrigem();
        this.estadoConservacao = dados.estadoConservacao();
        this.caracteristica = dados.caracteristica();
        this.sala_fixa_id = sala;

    }

    public void atualizarInstrumento(DadosAtualizacaoInstrumento dados, Sala sala) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if (dados.numeroSerie() != null) {
            this.numeroSerie = dados.numeroSerie();
        }
        if (dados.anoFabricacao() > 0) {
            this.anoFabricacao = dados.anoFabricacao();
        }
        if (dados.paisOrigem() != null) {
            this.paisOrigem = dados.paisOrigem();
        }
        if (dados.estadoConservacao() != null) {
            this.estadoConservacao = dados.estadoConservacao();
        }
        if (dados.caracteristica() != null) {
            this.caracteristica = dados.caracteristica();
        }
        if (dados.tipoInstrumento() != null) {
            this.tipoInstrumento = dados.tipoInstrumento();
        }
        if (sala != null) {
            this.sala_fixa_id = sala;
        }
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.setSala(null);
    }
}
