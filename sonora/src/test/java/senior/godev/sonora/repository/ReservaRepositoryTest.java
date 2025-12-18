package senior.godev.sonora.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ReservaRepositoryTest {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull() {
    }

    @Test
    void existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNullAndIdMembroAndIdSala() {
    }

    @Test
    void findAllById() {
    }

    @Test
    void findAllbyDataHoraInicio() {
    }

    @Test
    void findAllReservasPendentesVencendo() {
    }

    @Test
    void findProximoEmEspera() {
    }
}