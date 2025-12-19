package senior.godev.sonora.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.TipoInstrumento;
import senior.godev.sonora.models.instrumento.dto.DadosCadastroInstrumento;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.membro.endereco.Endereco;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.reserva.TipoUso;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.models.usuario.IdentificacaoUsuario;
import senior.godev.sonora.models.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class InstrumentoRepositoryTest {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Autowired
    private TestEntityManager em;

    private Usuario cadastrarUsuario() {
        var usuario = new Usuario();

        setField(usuario, "login", "login_l");
        setField(usuario, "senha", "@kKs912");
        setField(usuario, "email", "usuario.e@email.com");

        setField(usuario, "role", IdentificacaoUsuario.ALUNO);

        em.persist(usuario);
        return usuario;
    }

    private Membro cadastrarMembro(String nome, String email) {
        var usuario = cadastrarUsuario();

        var endereco = new Endereco();
        setField(endereco, "logradouro", "Rua dos Testes");
        setField(endereco, "bairro", "Centro");
        setField(endereco, "cep", "89000000");
        setField(endereco, "numero", "123");
        setField(endereco, "uf", "SC");
        setField(endereco, "cidade", "Gaspar");

        var membro = new Membro();
        setField(membro, "usuario", usuario);
        setField(membro, "nome", nome);
        setField(membro, "email", email);
        setField(membro, "cpf", "05845678901");
        setField(membro, "dataNascimento", java.time.LocalDate.of(2000, 1, 1));
        setField(membro, "ativo", true);
        setField(membro, "telefone", "47999998877");

        setField(membro, "endereco", endereco);

        em.persist(membro);
        return membro;
    }

    private Sala cadastrarSala(String nome) {
        var sala = new Sala();
        setField(sala, "nome", nome);
        setField(sala, "capacidade", 10);
        setField(sala,"temAbafadores", Boolean.TRUE);
        em.persist(sala);
        return sala;
    }

    private Instrumento cadastrarInstrumento(String nome, String modelo, Sala sala) {
        var dados = new DadosCadastroInstrumento(
                TipoInstrumento.CORDAS,
                nome,
                modelo,
                "SN123",
                2024,
                "Brasil", "NOVO", "Obs", null
        );
        var instrumento = new Instrumento(dados, sala);
        em.persist(instrumento);
        return instrumento;
    }

    private Reserva cadastrarReserva(Instrumento instrumento, Sala sala, Membro membro, LocalDateTime inicio, LocalDateTime fim, MotivoCancelamento motivo) {
        var reserva = new Reserva();
        setField(reserva, "instrumento", instrumento);
        setField(reserva, "sala", sala);
        setField(reserva, "membro", membro);
        setField(reserva, "dataHoraInicio", inicio);
        setField(reserva, "dataHoraFim", fim);
        setField(reserva, "dataHoraRegistro", LocalDateTime.now());
        setField(reserva, "emEspera", false);
        setField(reserva, "tipoUso", TipoUso.AULA);
        setField(reserva, "motivoCancelamento", motivo);
        em.persist(reserva);
        return reserva;
    }

    // --- TESTES ---

    @Test
    @DisplayName("Deveria retornar lista de reservas vinculadas ao instrumento pelo ID correto")
    void findAllReservaById_CenarioSucesso() {
        var sala = cadastrarSala("Sala de Ensaio");
        var instrumento = cadastrarInstrumento("Violoncelo", "Stradivarius", sala);
        var membro = cadastrarMembro("Membro Teste", "teste@email.com");

        cadastrarReserva(instrumento, sala, membro, LocalDateTime.now(), LocalDateTime.now().plusHours(1), null);

        List<Reserva> reservas = instrumentoRepository.findAllReservaById(instrumento.getId());

        assertThat(reservas).isNotEmpty();
        assertThat(reservas.get(0).getInstrumento().getId()).isEqualTo(instrumento.getId());
    }

    @Test
    @DisplayName("Deveria validar se o instrumento está ocupado apenas por reservas não canceladas")
    void instrumentoReservado_CenarioLogicaCancelamento() {
        var agora = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
        var sala = cadastrarSala("Auditório");
        var instrumento = cadastrarInstrumento("Harpa", "Clássica", sala);
        var membro = cadastrarMembro("Membro 2", "membro2@email.com");

        cadastrarReserva(instrumento, sala, membro, agora.withHour(14), agora.withHour(15), MotivoCancelamento.FALTA_INSTRUMENTO);
        var ocupado = instrumentoRepository.instrumentoReservado(instrumento.getId(), agora.withHour(14), agora.withHour(15));
        assertThat(ocupado).isNotEqualTo(true);

        cadastrarReserva(instrumento, sala, membro, agora.withHour(16), agora.withHour(17), null);
        var ocupadoAgora = instrumentoRepository.instrumentoReservado(instrumento.getId(), agora.withHour(16), agora.withHour(17));
        assertThat(ocupadoAgora).isFalse();
    }

    @Test
    @DisplayName("Deveria retornar a lista de instrumentos com o status de uso")
    void findAllAndReserva_CenarioListagem() {
        var agora = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
        var sala = cadastrarSala("Sala C");
        var instrumento = cadastrarInstrumento("Guitarra", "Stratocaster", sala);
        var membro = cadastrarMembro("Membro 3", "membro3@email.com");

        cadastrarReserva(instrumento, sala, membro, agora, agora.plusHours(1), null);

        var pagina = instrumentoRepository.findAllAndReserva(
                org.springframework.data.domain.PageRequest.of(0, 10),
                agora.minusMinutes(10),
                agora.plusMinutes(10)
        );

        assertThat(pagina.getContent()).anyMatch(p -> p.getNome().equals("Guitarra") && p.getEmUso());
    }
}