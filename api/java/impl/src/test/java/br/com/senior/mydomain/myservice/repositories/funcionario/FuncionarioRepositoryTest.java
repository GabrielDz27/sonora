package br.com.senior.mydomain.myservice.repositories.funcionario;

import static org.junit.jupiter.api.Assertions.*;

import br.com.senior.mydomain.myservice.FuncionarioEntity;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FuncionarioRepositoryTest {

    @Test
    public void deveExecutarMetodosDoRepository() {
        FuncionarioRepository repo = mock(FuncionarioRepository.class);

        UUID id = UUID.randomUUID();
        FuncionarioEntity entity = mock(FuncionarioEntity.class);

        when(repo.findFuncionarioByUsername("user")).thenReturn(entity);

        repo.desativar(id);
        FuncionarioEntity result = repo.findFuncionarioByUsername("user");

        assertEquals(entity, result);

        verify(repo).desativar(id);
        verify(repo).findFuncionarioByUsername("user");
        verifyNoMoreInteractions(repo);
    }
}