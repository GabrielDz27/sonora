package senior.godev.sonora.models.reserva;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.sala.Sala;

import java.time.LocalDateTime;

@Entity(name = "Reserva")
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "instrumento_id", nullable = true)
    private Instrumento instrumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_id")
    private Membro membro;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;
    private LocalDateTime dataHoraRegistro;
    private Boolean emEspera;

    @Column(name = "tipo_uso")
    @Enumerated(EnumType.STRING)
    private TipoUso tipoUso;

    private String observacoes;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public void cancelar(MotivoCancelamento motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public void confirmar() {
        this.motivoCancelamento = null;
    }
}
