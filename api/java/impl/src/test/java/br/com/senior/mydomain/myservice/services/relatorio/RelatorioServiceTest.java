package br.com.senior.mydomain.myservice.services.relatorio;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RelatorioServiceTest {

    @InjectMocks
    private RelatorioService service;

    @Mock
    private RegistroProducaoRepository registroRepo;

    @Mock
    private MaquinaRepository maquinaRepo;

    @Mock
    private PecaRepository pecaRepo;

    private RelatorioInput input;

    @Before
    public void setup() {

        input = new RelatorioInput();
        input.dataInicio = Instant.now();
        input.dataFinal = Instant.now();
        input.maquina = List.of("11111111-1111-1111-1111-111111111111");
        input.funcionario = List.of("func1");
        input.codigoDesenho = List.of("des1");
        input.turno = TurnoFuncionario.PRIMEIRO;
        input.tipoRelatorio = TipoRelatorio.PERIODO;
    }

    @Test
    public void deveRetornarRelatorioComDados() {

        List<MaquinaTrabalhando> maquinasMock = List.of(new MaquinaTrabalhando());
        List<PecaFuncionario> funcMock = List.of(new PecaFuncionario());

        when(maquinaRepo.maquinaTrabalhada(any(), any(), any()))
                .thenReturn(maquinasMock);

        when(pecaRepo.countPecaMorta(any(), any(), any()))
                .thenReturn(5L);

        when(registroRepo.pecaPorFuncionario(any(), any(), any(), any()))
                .thenReturn(funcMock);

        List<RetornoRelatorio> result = service.retornaDados(input);

        assertNotNull(result);
        assertEquals(1, result.size());

        RetornoRelatorio r = result.get(0);

        assertEquals(maquinasMock, r.maquinaTrabalhando);
        assertEquals(Long.valueOf(5), r.pecaMortas);
        assertEquals(funcMock, r.pecaFuncionario);

        verify(maquinaRepo).maquinaTrabalhada(any(), any(), any());
        verify(pecaRepo).countPecaMorta(any(), any(), any());
        verify(registroRepo).pecaPorFuncionario(any(), any(), any(), any());
    }
}