package br.com.senior.mydomain.myservice.handler.peca;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.services.peca.PecaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class GetPecaHandlerImplTest {

    @InjectMocks
    private GetPecaHandlerImpl handler;

    @Mock
    private PecaService service;

    @Mock
    private PecaEntity entity;

    @Test
    public void deveConverterListaDePecasCorretamente() {
        UUID id = UUID.randomUUID();

        GetPecaInput input = new GetPecaInput();
        input.status = StatusPeca.PENDENTE;

        when(service.getPecasPendentes(StatusPeca.PENDENTE))
                .thenReturn(Arrays.asList(entity));

        when(entity.getId()).thenReturn(id);
        when(entity.getNome()).thenReturn("Peça A");
        when(entity.getCodigoDesenho()).thenReturn("CD01");
        when(entity.getTempoEstimadoMinutos()).thenReturn(30L);
        when(entity.getStatus()).thenReturn(StatusPeca.PENDENTE);
        when(entity.getValor()).thenReturn(new BigDecimal("100.00"));
        when(entity.getMotivoPerda()).thenReturn("Nenhum");

        GetPecaOutput output = handler.getPeca(input);

        assertNotNull(output);
        assertNotNull(output.peca);
        assertEquals(1, output.peca.size());

        Peca peca = output.peca.get(0);
        assertEquals(id.toString(), peca.id);
        assertEquals("Peça A", peca.nome);
        assertEquals("CD01", peca.codigoDesenho);
        assertEquals(new Long(30) , peca.tempoEstimadoMinutos);
        assertEquals(StatusPeca.PENDENTE, peca.status);
        assertEquals(new BigDecimal("100.00"), peca.valor);
        assertEquals("Nenhum", peca.motivoPerda);

        verify(service).getPecasPendentes(StatusPeca.PENDENTE);
        verifyNoMoreInteractions(service);
    }
}