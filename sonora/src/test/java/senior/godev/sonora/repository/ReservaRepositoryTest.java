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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ReservaRepositoryTest {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private TestEntityManager em;

    private Usuario cadastrarUsuario() {
        var usuario = new Usuario();

        setField(usuario, "login", "login_l");
        setField(usuario, "senha", "@kKs912");
        setField(usuario, "email", "usuario.e@email.com"); // Adicionamos o e-mail aqui!

        setField(usuario, "role", IdentificacaoUsuario.ALUNO);

        em.persist(usuario);
        return usuario;
    }

    private Usuario cadastrarUsuario(String login, String email) {
        var usuario = new Usuario();

        setField(usuario, "login", login);
        setField(usuario, "senha", "@kKs912");
        setField(usuario, "email", email);

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


    private Membro cadastrarMembro(String nome, String email, String login, String cpf) {
        var usuario = cadastrarUsuario(login,email);

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
        setField(membro, "cpf", cpf);
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

    @Test
    @DisplayName("Deveria detectar se a sala já possui uma reserva ativa no intervalo")
    void existsByDataHora_CenarioSalaOcupada() {
        var agora = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
        var sala = cadastrarSala("Sala 01");
        var instrumento = cadastrarInstrumento("Violão", "Fender", sala);
        var membro = cadastrarMembro("Membro A", "a@email.com");

        cadastrarReserva(instrumento, sala, membro, agora.withHour(14), agora.withHour(15), null);

        var ocupado = reservaRepository.existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(
                sala.getId(),
                agora.withHour(14).withMinute(15),
                agora.withHour(14).withMinute(45)
        );

        assertThat(ocupado).isTrue();
    }

    @Test
    @DisplayName("Deveria detectar se o membro já tem reserva em outra sala no mesmo horário")
    void existsByMembroESala_CenarioConflitoMembro() {
        var agora = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
        var salaA = cadastrarSala("Sala A");
        var salaB = cadastrarSala("Sala B");
        var instrumento = cadastrarInstrumento("Piano", "Steinway", salaA);
        var membro = cadastrarMembro("Membro B", "b@email.com");

        cadastrarReserva(instrumento, salaA, membro, agora.withHour(10), agora.withHour(11), null);

        var conflito = reservaRepository.existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNullAndIdMembroAndIdSala(
                agora.withHour(10), agora.withHour(11), membro.getId(), salaB.getId()
        );

        assertThat(conflito).isTrue();
    }

    @Test
    @DisplayName("Deveria encontrar o próximo membro na fila de espera por ordem de registro")
    void findProximoEmEspera_CenarioFila() {
        var agora = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
        var sala = cadastrarSala("Auditório");
        var instrumento = cadastrarInstrumento("Harpa", "X", sala);

        var membro1 = cadastrarMembro("Primeiro", "1@e.com", "usuario_1","12345678909");
        var membro2 = cadastrarMembro("Segundo", "2@e.com", "usuario_2","05845678901");

        var r1 = cadastrarReserva(instrumento, sala, membro1, agora.withHour(18), agora.withHour(19), null);
        setField(r1, "emEspera", true);
        em.persist(r1);

        var r2 = cadastrarReserva(instrumento, sala, membro2, agora.withHour(18), agora.withHour(19), null);
        setField(r2, "emEspera", true);
        em.persist(r2);

        var proximo = reservaRepository.findProximoEmEspera(sala.getId(), agora.withHour(18));

        assertThat(proximo).isPresent();
        assertThat(proximo.get().getMembro().getNome()).isEqualTo("Primeiro");
    }

}