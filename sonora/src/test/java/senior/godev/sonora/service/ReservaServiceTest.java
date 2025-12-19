package senior.godev.sonora.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.reserva.TipoUso;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;
import senior.godev.sonora.models.reserva.dto.DadosCancelamentoReserva;
import senior.godev.sonora.models.reserva.dto.DadosConfirmacaoReserva;
import senior.godev.sonora.models.reserva.validacao.cancelamento.ValidadorCancelamento;
import senior.godev.sonora.models.reserva.validacao.confirmacao.ValidadorConfirmacao;
import senior.godev.sonora.models.reserva.validacao.reservamento.ValidadorHorarioFuncionamento;
import senior.godev.sonora.models.reserva.validacao.reservamento.ValidadorReservamento;
import senior.godev.sonora.models.reserva.validacao.reservamento.ValidadorRole;
import senior.godev.sonora.models.reserva.validacao.reservamento.ValidarMembroAtivo;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.models.usuario.IdentificacaoUsuario;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservaServiceTest {

    @InjectMocks
    private ReservaService service;

    @Mock
    private UsuarioRepository userRepository;
    @Mock
    private ReservaRepository reservaRepository;
    @Mock
    private MembroRepository membroRepository;
    @Mock
    private InstrumentoRepository instrumentoRepository;
    @Mock
    private SalaRepository salaRepository;
    @Mock
    private EmailService emailService;
    @Spy
    private final List<ValidadorReservamento> validadores = new ArrayList<>();
    @Spy
    private final List<ValidadorConfirmacao> validadorConfirmacoes = new ArrayList<>();
    @Spy
    private final List<ValidadorCancelamento> validadorCancelamentos = new ArrayList<>();

    private DadosCadastroReserva dadosCadastro;

    @BeforeEach
    void setup() {
        dadosCadastro = new DadosCadastroReserva(
                1L, // idMembro
                1L, // idSala
                1L, // idInstrumento
                LocalDateTime.now().plusDays(1).withHour(10),
                LocalDateTime.now().plusDays(1).withHour(11),
                TipoUso.ESTUDO_INDIVIDUAL,
                "Obs teste"
        );
    }

    @Nested
    @DisplayName("Testes de Reservamento")
    class Reservar {

        @Test
        @DisplayName("Deve reservar com sucesso (Sem fila de espera)")
        void reservarCenario01() {
            when(salaRepository.existsById(any())).thenReturn(true);
            when(membroRepository.existsById(any())).thenReturn(true);
            when(instrumentoRepository.existsById(any())).thenReturn(true);

            when(reservaRepository.existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(any(), any(), any()))
                    .thenReturn(false);

            when(salaRepository.findAllById(anyLong())).thenReturn(new Sala());
            when(membroRepository.findAllById(anyLong())).thenReturn(new Membro());
            when(instrumentoRepository.findAllById(anyLong())).thenReturn(new Instrumento());

            var dto = service.reservar(dadosCadastro);

            assertThat(dto.emEspera()).isEqualTo("Reservado");
            verify(reservaRepository).save(any());
        }

        @Test
        @DisplayName("Deve reservar com sucesso e entrar na fila de espera")
        void reservarCenario02() {
            when(salaRepository.existsById(any())).thenReturn(true);
            when(membroRepository.existsById(any())).thenReturn(true);
            when(instrumentoRepository.existsById(any())).thenReturn(true);

            when(reservaRepository.existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(any(), any(), any()))
                    .thenReturn(true);

            when(salaRepository.findAllById(anyLong())).thenReturn(new Sala());
            when(membroRepository.findAllById(anyLong())).thenReturn(new Membro());
            when(instrumentoRepository.findAllById(anyLong())).thenReturn(new Instrumento());

            var dto = service.reservar(dadosCadastro);

            assertThat(dto.emEspera()).isEqualTo("Na fila de espera");
            verify(reservaRepository).save(any());
        }

        @Test
        @DisplayName("Deve lançar exceção se ID da sala não existir")
        void reservarCenarioErroSala() {
            when(salaRepository.existsById(any())).thenReturn(false);

            assertThrows(ValidacaoException.class, () -> service.reservar(dadosCadastro));
        }
    }

    @Nested
    @DisplayName("Testes de Cancelamento e Promoção")
    class Cancelamento {

        @Test
        @DisplayName("Deve cancelar e promover o próximo da fila enviando e-mail")
        void cancelarESugerirProximo() {

            var dadosCancelamento = new DadosCancelamentoReserva(1L, MotivoCancelamento.AULA_CANCELADA);
            var reservaAtual = new Reserva();
            reservaAtual.setSala(new Sala());
            reservaAtual.setDataHoraInicio(LocalDateTime.now());

            var proximoFila = new Reserva();
            proximoFila.setSala(new Sala());
            proximoFila.setMembro(new Membro());

            when(reservaRepository.existsById(any())).thenReturn(true);
            when(reservaRepository.getReferenceById(any())).thenReturn(reservaAtual);

            when(reservaRepository.findProximoEmEspera(any(), any())).thenReturn(Optional.of(proximoFila));

            service.cancelar(dadosCancelamento);

            assertThat(proximoFila.getMotivoCancelamento()).isEqualTo(MotivoCancelamento.PENDENTE_CONFIRMACAO);
            verify(emailService).enviarEmailConfirmacaoPromocao(proximoFila);
        }
    }

    @Nested
    @DisplayName("Testes de Confirmação")
    class Confirmacao {

        @Test
        @DisplayName("Deve confirmar reserva com sucesso")
        void confirmarSucesso() {
            var dados = new DadosConfirmacaoReserva(1L);
            var reserva = new Reserva();
            reserva.setMotivoCancelamento(MotivoCancelamento.PENDENTE_CONFIRMACAO);

            when(reservaRepository.existsById(any())).thenReturn(true);
            when(reservaRepository.getReferenceById(any())).thenReturn(reserva);

            service.confirmar(dados);

            assertThat(reserva.getMotivoCancelamento()).isNull();
        }
    }

    @Test
    @DisplayName("Deve listar reservas e mapear corretamente o status de espera")
    void listagemCenario01() {
        var paginacao = PageRequest.of(0, 10);

        var reserva = mock(Reserva.class);
        var sala = new Sala();
        var membro = new Membro();
        var instrumento = new Instrumento();
        instrumento.setNome("Piano");

        when(reserva.getSala()).thenReturn(sala);
        when(reserva.getMembro()).thenReturn(membro);
        when(reserva.getInstrumento()).thenReturn(instrumento);
        when(reserva.getEmEspera()).thenReturn(true); // Simulando que está em espera

        var pagina = new PageImpl<>(List.of(reserva));
        when(reservaRepository.findAll(any(Pageable.class))).thenReturn(pagina);

        var resultado = service.listagem(paginacao);

        assertThat(resultado.getContent()).isNotEmpty();
        assertThat(resultado.getContent().get(0).emEspera()).isEqualTo("Na fila de espera");
    }

    @Nested
    @DisplayName("Testes de Processos de Cancelamento")
    class ProcessosCancelamento {

        @Test
        @DisplayName("Deve cancelar reserva e disparar promoção para o próximo da fila")
        void cancelamentoFinalEPromocaoSucesso() {

            var reservaASerCancelada = new Reserva();
            reservaASerCancelada.setId(1L);
            var sala = new Sala();
            sala.setId(10L);
            reservaASerCancelada.setSala(sala);
            reservaASerCancelada.setDataHoraInicio(LocalDateTime.now());

            var motivo = MotivoCancelamento.AULA_CANCELADA;

            var proximoDaFila = new Reserva();
            proximoDaFila.setId(2L);
            proximoDaFila.setSala(sala);
            proximoDaFila.setMembro(new Membro());

            when(reservaRepository.findProximoEmEspera(anyLong(), any())).thenReturn(Optional.of(proximoDaFila));

            service.cancelamentoFinalEPromocao(reservaASerCancelada, motivo);

            assertThat(reservaASerCancelada.getMotivoCancelamento()).isEqualTo(motivo);

            verify(reservaRepository).save(reservaASerCancelada);

            assertThat(proximoDaFila.getMotivoCancelamento()).isEqualTo(MotivoCancelamento.PENDENTE_CONFIRMACAO);
            verify(emailService).enviarEmailConfirmacaoPromocao(proximoDaFila);
        }
    }

    @Nested
    @DisplayName("Validações de Regras de Negócio ")
    class ValidacoesRegras {

        @BeforeEach
        void limparValidadores() {
            validadores.clear();
            lenient().when(salaRepository.existsById(any())).thenReturn(true);
            lenient().when(membroRepository.existsById(any())).thenReturn(true);
            lenient().when(instrumentoRepository.existsById(any())).thenReturn(true);
        }

        @Test
        @DisplayName("Deve barrar reserva de AULA feita por ALUNO")
        void validarRoleProfessor() {
            var validadorRole = new ValidadorRole();
            ReflectionTestUtils.setField(validadorRole, "membroRepository", membroRepository);
            ReflectionTestUtils.setField(validadorRole, "userRepository", userRepository);

            validadores.add(validadorRole);

            when(salaRepository.existsById(any())).thenReturn(true);
            when(membroRepository.existsById(any())).thenReturn(true);
            when(instrumentoRepository.existsById(any())).thenReturn(true);

            var membro = new Membro();
            var usuario = new Usuario();
            usuario.setLogin("aluno123");
            membro.setUsuario(usuario);

            var loginInfo = new Usuario();
            loginInfo.setRole(IdentificacaoUsuario.ALUNO);

            when(membroRepository.findAllById(anyLong())).thenReturn(membro);
            when(userRepository.findByLogin("aluno123")).thenReturn(Optional.of(loginInfo));

            var dadosAula = new DadosCadastroReserva(1L, 1L, 1L,
                    LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(1),
                    TipoUso.AULA, "Teste");

            assertThrows(ValidacaoException.class, () -> service.reservar(dadosAula),
                    "Somente professores podem fazer reserva para o tipo de uso AULA");
        }

        @Test
        @DisplayName("Deve barrar reserva fora do horário de funcionamento")
        void validarHorarioFuncionamento() {
            validadores.add(new ValidadorHorarioFuncionamento());

            var domingoDeMadrugada = LocalDateTime.now()
                    .with(TemporalAdjusters.next(DayOfWeek.SUNDAY))
                    .withHour(5);

            var dadosInvalidos = new DadosCadastroReserva(1L, 1L, 1L,
                    domingoDeMadrugada, domingoDeMadrugada.plusHours(1),
                    TipoUso.ESTUDO_INDIVIDUAL, "");

            assertThrows(ValidacaoException.class, () -> service.reservar(dadosInvalidos));
        }

        @Test
        @DisplayName("Deve barrar membro inativo")
        void validarMembroAtivo() {
            var validadorAtivo = new ValidarMembroAtivo();
            ReflectionTestUtils.setField(validadorAtivo, "membroRepository", membroRepository);
            validadores.add(validadorAtivo);

            var membroInativo = new Membro();
            membroInativo.setAtivo(false);
            when(membroRepository.findAllById(anyLong())).thenReturn(membroInativo);

            assertThrows(ValidacaoException.class, () -> service.reservar(dadosCadastro));
        }
    }
}