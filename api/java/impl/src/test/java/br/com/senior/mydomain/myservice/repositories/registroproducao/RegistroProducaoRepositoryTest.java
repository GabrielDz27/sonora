package br.com.senior.mydomain.myservice.repositories.registroproducao;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RegistroProducaoRepositoryTest {

    @Test
    public void deveExecutarMetodosRepository() {
        RegistroProducaoRepository repo = mock(RegistroProducaoRepository.class);

        UUID id = UUID.randomUUID();
        LocalDateTime agora = LocalDateTime.now();

        when(repo.isMaquinaUsada(agora, id)).thenReturn(true);

        repo.updateStatusById(agora, id);
        boolean result = repo.isMaquinaUsada(agora, id);

        assertTrue(result);

        verify(repo).updateStatusById(agora, id);
        verify(repo).isMaquinaUsada(agora, id);
        verifyNoMoreInteractions(repo);
    }
}