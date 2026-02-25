package br.com.senior.mydomain.myservice.handler.registroProducao;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.services.registroproducao.RegistroProducaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class FinalizarImplTest {

    @InjectMocks
    private FinalizarImpl handler;

    @Mock
    private RegistroProducaoService service;

    @Test
    public void deveFinalizarEEncapsularRetorno() {
        FinalizarInput input = new FinalizarInput();
        input.id = "abc123";

        RetornoAtualizarStatus retorno = mock(RetornoAtualizarStatus.class);

        when(service.finalizar("abc123")).thenReturn(retorno);

        FinalizarOutput output = handler.finalizar(input);

        assertNotNull(output);
        assertEquals(retorno, output.retorno);

        verify(service).finalizar("abc123");
        verifyNoMoreInteractions(service);
    }
}