package senior.godev.sonora.models.instrumento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.instrumento.formatacao.DadosAtualizacaoInstrumento;
import senior.godev.sonora.models.instrumento.formatacao.DadosCadastroInstrumento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;

import java.util.List;

@Entity
@Table(name = "instrumentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_instrumento")
    @Enumerated(EnumType.STRING)
    private TipoInstrumento tipoInstrumento;

    private String nome;

    private String modelo;

    private String numero_serie;

    private int ano_fabricacao;

    private String pais_origem;

    private String estado_conservacao;

    private String caracteristica;

    @ManyToOne
    @JoinColumn(name = "sala_fixa_id")
    private Sala sala_fixa_id;

    @OneToMany(mappedBy = "instrumento", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Reserva> reservas;

    public Instrumento(DadosCadastroInstrumento dados) {
        this.nome = dados.nome();
        this.modelo = dados.modelo();
        this.numero_serie = dados.numero_serie();
        this.ano_fabricacao = dados.ano_fabricacao();
        this.pais_origem = dados.pais_origem();
        this.estado_conservacao = dados.estado_conservacao();
        this.caracteristica = dados.caracteristica();
    }

    public void atualizarInstrumento(DadosAtualizacaoInstrumento dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if (dados.numero_serie() != null) {
            this.numero_serie = dados.numero_serie();
        }
        if (dados.ano_fabricacao() > 0) {
            this.ano_fabricacao = dados.ano_fabricacao();
        }
        if (dados.pais_origem() != null) {
            this.pais_origem = dados.pais_origem();
        }
        if (dados.estado_conservacao() != null) {
            this.estado_conservacao = dados.estado_conservacao();
        }
        if (dados.caracteristica() != null) {
            this.caracteristica = dados.caracteristica();
        }
    }

    public void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.setSala(null);
    }

}
