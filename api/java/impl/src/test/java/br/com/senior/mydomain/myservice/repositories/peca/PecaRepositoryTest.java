package br.com.senior.mydomain.myservice.repositories.peca;

import static org.junit.jupiter.api.Assertions.*;

import br.com.senior.mydomain.myservice.StatusPeca;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PecaRepositoryTest {

    @Test
    public void deveExecutarMetodosRepository() {
        PecaRepository repo = mock(PecaRepository.class);

        UUID id = UUID.randomUUID();

        when(repo.isPecaStatusNotPendente(id)).thenReturn(true);

        repo.updateStatusById(StatusPeca.PROCESSO, id);
        boolean result = repo.isPecaStatusNotPendente(id);

        assertTrue(result);

        verify(repo).updateStatusById(StatusPeca.PROCESSO, id);
        verify(repo).isPecaStatusNotPendente(id);
        verifyNoMoreInteractions(repo);
    }
}