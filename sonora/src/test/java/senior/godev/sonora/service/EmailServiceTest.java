package senior.godev.sonora.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.util.ReflectionTestUtils;
import senior.godev.sonora.models.dtoMail.Email;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.repository.MembroRepository;
import senior.godev.sonora.repository.ReservaRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    private EmailService emailService;

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private MembroRepository membroRepository;

    @Mock
    private ReservaService reservaService;

    @Captor
    private ArgumentCaptor<SimpleMailMessage> mailCaptor;

    private Reserva reservaExemplo;

    @BeforeEach
    void setup() {
        emailService = new EmailService(mailSender);

        ReflectionTestUtils.setField(emailService, "reservaRepository", reservaRepository);
        ReflectionTestUtils.setField(emailService, "membroRepository", membroRepository);

        emailService.setReservaService(reservaService);

        var sala = new Sala();
        sala.setId(1L);
        sala.setNome("Sala de Ensaio 01");

        var instrumento = new Instrumento();
        instrumento.setNome("Piano");

        var membro = new Membro();
        membro.setEmail("membro@teste.com");

        reservaExemplo = new Reserva();
        reservaExemplo.setSala(sala);
        reservaExemplo.setInstrumento(instrumento);
        reservaExemplo.setMembro(membro);
        reservaExemplo.setDataHoraInicio(LocalDateTime.now().plusHours(1));
    }

    @Test
    @DisplayName("Deve enviar e-mail genérico com sucesso")
    void send_CenarioSucesso() {
        var emailDto = new Email("destino@teste.com", "Assunto", "Corpo do e-mail");

        emailService.send(emailDto);

        verify(mailSender).send(mailCaptor.capture());
        var message = mailCaptor.getValue();

        assertThat(message.getTo()[0]).isEqualTo("destino@teste.com");
        assertThat(message.getSubject()).isEqualTo("Assunto");
        assertThat(message.getText()).isEqualTo("Corpo do e-mail");
    }

    @Nested
    @DisplayName("Testes de Métodos Agendados (@Scheduled)")
    class ScheduledTests {

        @Test
        @DisplayName("Deve processar reservas matinais e chamar pre-cancelamento")
        void enviarEmailDiarioAsCincoDaManha_Sucesso() {

            when(reservaRepository.findAllbyDataHoraInicio(any())).thenReturn(List.of(reservaExemplo));


            emailService.enviarEmailDiarioAsCincoDaManha();


            verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
            verify(reservaService).preCancelamento(reservaExemplo, MotivoCancelamento.NAO_CONFIRMACAO_TEMPO);
        }

        @Test
        @DisplayName("Deve cancelar definitivamente reservas expiradas na checagem de 10 minutos")
        void checarEConfirmarReservas_CenarioExpirado() {

            reservaExemplo.setDataHoraInicio(LocalDateTime.now().minusMinutes(1));
            when(reservaRepository.findAllReservasPendentesVencendo(any())).thenReturn(List.of(reservaExemplo));


            emailService.checarEConfirmarReservas();


            verify(reservaService).cancelamentoFinalEPromocao(reservaExemplo, MotivoCancelamento.NAO_CONFIRMACAO_TEMPO);
            verify(mailSender).send(any(SimpleMailMessage.class));
        }
    }

    @Nested
    @DisplayName("Testes de Notificações de Fluxo")
    class NotificacoesFluxo {

        @Test
        @DisplayName("Deve montar e enviar e-mail de promoção da fila de espera")
        void enviarEmailConfirmacaoPromocao_Sucesso() {

            emailService.enviarEmailConfirmacaoPromocao(reservaExemplo);


            verify(mailSender).send(mailCaptor.capture());
            var message = mailCaptor.getValue();

            assertThat(message.getTo()[0]).isEqualTo("membro@teste.com");
            assertThat(message.getSubject()).isEqualTo("SONORA: Confirmação e Disponibilidade da reserva");
            assertThat(message.getText()).contains("liberada");
            assertThat(message.getText()).contains("Sala de Ensaio 01");
        }
    }
}