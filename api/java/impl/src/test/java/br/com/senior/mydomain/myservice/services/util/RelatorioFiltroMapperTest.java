package br.com.senior.mydomain.myservice.services.util;
import br.com.senior.mydomain.myservice.RelatorioInput;
import br.com.senior.mydomain.myservice.TurnoFuncionario;
import org.junit.Test;
import org.mockito.MockedStatic;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RelatorioFiltroMapperTest {

    @Test
    public void deveMapearCamposCorretamente() {

        RelatorioInput input = new RelatorioInput();
        input.dataInicio = Instant.parse("2024-01-01T10:00:00Z");
        input.dataFinal = Instant.parse("2024-01-02T10:00:00Z");
        input.turno = TurnoFuncionario.PRIMEIRO;
        input.funcionario = List.of("1","2");
        input.maquina = List.of("10");
        input.codigoDesenho = List.of("DX");

        LocalDateTime inicioEsperado =
                LocalDateTime.ofInstant(input.dataInicio, ZoneId.systemDefault());

        LocalDateTime fimEsperado =
                LocalDateTime.ofInstant(input.dataFinal, ZoneId.systemDefault());

        LocalDateTime[] periodoMock =
                new LocalDateTime[]{inicioEsperado, fimEsperado};

        try (MockedStatic<PeriodoResolver> mocked =
                     mockStatic(PeriodoResolver.class)) {

            mocked.when(() ->
                    PeriodoResolver.resolver(inicioEsperado, fimEsperado, input.tipoRelatorio)
            ).thenReturn(periodoMock);

            RelatorioFiltro result = RelatorioFiltroMapper.fromInput(input);

            assertEquals(inicioEsperado, result.inicio);
            assertEquals(fimEsperado, result.fim);
            assertEquals("PRIMEIRO", result.turno);
            assertEquals(input.funcionario, result.funcionarios);
            assertEquals(input.maquina, result.maquinas);
            assertEquals(input.codigoDesenho, result.desenhos);
        }
    }

    @Test
    public void deveAceitarDatasNull() {

        RelatorioInput input = new RelatorioInput();
        input.turno = TurnoFuncionario.DIURNO;

        LocalDateTime[] periodoMock =
                new LocalDateTime[]{null, null};

        try (MockedStatic<PeriodoResolver> mocked =
                     mockStatic(PeriodoResolver.class)) {

            mocked.when(() ->
                    PeriodoResolver.resolver(null, null, input.tipoRelatorio)
            ).thenReturn(periodoMock);

            RelatorioFiltro result = RelatorioFiltroMapper.fromInput(input);

            assertNull(result.inicio);
            assertNull(result.fim);
            assertEquals("DIURNO", result.turno);
        }
    }
}