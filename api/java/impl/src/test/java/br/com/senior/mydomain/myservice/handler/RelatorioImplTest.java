package br.com.senior.mydomain.myservice.handler;

import br.com.senior.mydomain.myservice.RelatorioInput;
import br.com.senior.mydomain.myservice.RelatorioOutput;
import br.com.senior.mydomain.myservice.RetornoRelatorio;
import br.com.senior.mydomain.myservice.services.relatorio.RelatorioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RelatorioImplTest {

    @InjectMocks
    private RelatorioImpl handler;

    @Mock
    private RelatorioService service;

    @Test
    public void deveRetornarRelatorioComSucesso() {

        RelatorioInput input = new RelatorioInput();

        RetornoRelatorio item = mock(RetornoRelatorio.class);
        List<RetornoRelatorio> listaMock = List.of(item);

        when(service.retornaDados(input)).thenReturn(listaMock);

        RelatorioOutput output = handler.relatorio(input);

        assertNotNull(output);
        assertEquals(listaMock, output.retorno);
        assertEquals(1, output.retorno.size());

        verify(service).retornaDados(input);
    }
}