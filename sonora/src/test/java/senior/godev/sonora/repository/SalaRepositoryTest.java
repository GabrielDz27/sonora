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
class SalaRepositoryTest {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void findAllAndInstrumentoById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findAllReservaById() {
    }

    @Test
    void findAllInstrumentoById() {
    }

    @Test
    void findAllById() {
    }

    @Test
    void findAllAndReserva() {
    }
}