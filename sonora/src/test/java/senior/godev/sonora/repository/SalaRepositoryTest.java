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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class SalaRepositoryTest {

    @Autowired
    private SalaRepository salaRepository;

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

    @Test
    @DisplayName("Deveria retornar o detalhamento da sala com a contagem de instrumentos correta")
    void findAllAndInstrumentoById_CenarioSucesso() {
        var sala = cadastrarSala("Sala de Piano");
        cadastrarInstrumento("Piano de Cauda", "Yamaha", sala);
        cadastrarInstrumento("Metrônomo Digital", "Korg", sala);

        var resultadoOptional = salaRepository.findAllAndInstrumentoById(sala.getId());

        assertThat(resultadoOptional).isPresent();
        var projection = resultadoOptional.get();
        assertThat(projection.getQuantidadeInstrumentos()).isEqualTo(2);
        assertThat(projection.getNomesInstrumentos()).contains("Piano de Cauda", "Metrônomo Digital");
    }

    @Test
    @DisplayName("Deveria retornar todas as reservas vinculadas a uma sala específica")
    void findAllReservaById_CenarioSucesso() {
        var sala = cadastrarSala("Estúdio A");
        var instrumento = cadastrarInstrumento("Bateria", "Pearl", sala);
        var membro = cadastrarMembro("João Silva", "joao@email.com");
        cadastrarReserva(instrumento, sala, membro, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);

        var reservas = salaRepository.findAllReservaById(sala.getId());

        assertThat(reservas).isNotEmpty();
        assertThat(reservas).hasSize(1);
        assertThat(reservas.get(0).getSala().getId()).isEqualTo(sala.getId());
    }

    @Test
    @DisplayName("Deveria retornar a lista de instrumentos que pertencem à sala")
    void findAllInstrumentoById_CenarioSucesso() {
        var sala = cadastrarSala("Sala 01");
        cadastrarInstrumento("Violão", "Fender", sala);

        var instrumentos = salaRepository.findAllInstrumentoById(sala.getId());

        assertThat(instrumentos).hasSize(1);
        assertThat(instrumentos.get(0).getNome()).isEqualTo("Violão");
    }

    @Test
    @DisplayName("Deveria listar salas e identificar corretamente qual está em uso no horário")
    void findAllAndReserva_CenarioOcupacao() {

        var agora = LocalDateTime.now();
        var salaOcupada = cadastrarSala("Sala Ocupada");
        var salaLivre = cadastrarSala("Sala Livre");

        var instrumento = cadastrarInstrumento("Guitarra", "Gibson", salaOcupada);
        var membro = cadastrarMembro("Membro Teste", "teste@email.com");

        cadastrarReserva(instrumento, salaOcupada, membro, agora.minusMinutes(30), agora.plusMinutes(30), null);

        var pagina = salaRepository.findAllAndReserva(
                org.springframework.data.domain.PageRequest.of(0, 10),
                agora.minusMinutes(10),
                agora.plusMinutes(10)
        );

        var lista = pagina.getContent();

        assertThat(lista).anyMatch(s -> s.getNome().equals("Sala Ocupada") && s.getEmUso());

        assertThat(lista).anyMatch(s -> s.getNome().equals("Sala Livre") && !s.getEmUso());
    }
}