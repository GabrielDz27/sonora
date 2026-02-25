package br.com.senior.mydomain.myservice.handler.peca;

import static org.junit.jupiter.api.Assertions.*;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.services.peca.PecaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MudarStatusPecaImplTest {

    @InjectMocks
    private MudarStatusPecaImpl handler;

    @Mock
    private PecaService service;

    @Test
    public void deveRetornarOutputComRetornoService() {
        MudarStatusPecaInput input = new MudarStatusPecaInput();
        input.id = "123";
        input.status = StatusPeca.PROCESSO;

        RetornoAtualizarStatus retorno = mock(RetornoAtualizarStatus.class);

        when(service.atualizarStatus("123", StatusPeca.PROCESSO))
                .thenReturn(retorno);

        MudarStatusPecaOutput output = handler.mudarStatusPeca(input);

        assertNotNull(output);
        assertEquals(retorno, output.retornoAtualizarStatus);

        verify(service).atualizarStatus("123", StatusPeca.PROCESSO);
        verifyNoMoreInteractions(service);
    }
}