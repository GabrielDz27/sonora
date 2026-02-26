package br.com.senior.mydomain.myservice.handler.registroProducao;

import br.com.senior.mydomain.myservice.RecordRegistroProducao;
import br.com.senior.mydomain.myservice.RetornaRegistroProducaoOutput;
import br.com.senior.mydomain.myservice.services.registroproducao.RegistroProducaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RetornaRegistroProducaoImplTest {

    @InjectMocks
    private RetornaRegistroProducaoImpl handler;

    @Mock
    private RegistroProducaoService service;

    @Test
    public void deveRetornarListaDeRegistros() {
        List<RecordRegistroProducao> mockList =
                Arrays.asList(mock(RecordRegistroProducao.class),
                        mock(RecordRegistroProducao.class));

        when(service.listagemRegistroProducao()).thenReturn(mockList);

        RetornaRegistroProducaoOutput output = handler.retornaRegistroProducao();

        assertNotNull(output);
        assertEquals(mockList, output.retorno);

        verify(service).listagemRegistroProducao();
    }
}