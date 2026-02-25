package br.com.senior.mydomain.myservice.repositories.maquina;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MaquinaRepositoryTest {

    @Test
    public void deveExecutarMetodoRepository() {
        MaquinaRepository repo = mock(MaquinaRepository.class);

        UUID id = UUID.randomUUID();

        when(repo.isMaquinaStatusNotAtiva(id)).thenReturn(true);

        boolean result = repo.isMaquinaStatusNotAtiva(id);

        assertTrue(result);

        verify(repo).isMaquinaStatusNotAtiva(id);
        verifyNoMoreInteractions(repo);
    }
}