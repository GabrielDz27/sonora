package br.com.senior.mydomain.myservice.handler.funcionario;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.services.funcionario.FuncionarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RetornaIdFuncionarioImplTest {

    @InjectMocks
    private RetornaIdFuncionarioImpl handler;

    @Mock
    private FuncionarioService service;

    @Mock
    private FuncionarioEntity entity;

    @Test
    public void deveRetornarIdENomeFuncionario() {
        RetornaIdFuncionarioInput input = new RetornaIdFuncionarioInput();
        input.username = "gabriel";

        UUID id = UUID.randomUUID();

        when(service.findFuncionanrioByUsername("gabriel")).thenReturn(entity);
        when(entity.getId()).thenReturn(id);
        when(entity.getNome()).thenReturn("Gabriel");

        RetornaIdFuncionarioOutput output = handler.retornaIdFuncionario(input);

        assertNotNull(output);
        assertEquals(id.toString(), output.id);
        assertEquals("Gabriel", output.nome);

        verify(service).findFuncionanrioByUsername("gabriel");
        verifyNoMoreInteractions(service);
    }
}