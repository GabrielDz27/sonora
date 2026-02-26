package br.com.senior.mydomain.myservice.services.util;

import br.com.senior.mydomain.myservice.TipoRelatorio;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class PeriodoResolverTest {

    @Test
    public void deveRetornarMesmoPeriodoQuandoTipoNull() {

        LocalDateTime inicio = LocalDateTime.of(2024,1,10,10,0);
        LocalDateTime fim = LocalDateTime.of(2024,1,20,10,0);

        LocalDateTime[] result =
                PeriodoResolver.resolver(inicio,fim,null);

        assertEquals(inicio,result[0]);
        assertEquals(fim,result[1]);
    }

    @Test
    public void deveResolverPeriodoMensal() {

        LocalDateTime inicio = LocalDateTime.of(2024, Month.MARCH,15,14,30);

        LocalDateTime[] result =
                PeriodoResolver.resolver(inicio,null, TipoRelatorio.MENSAL);

        assertEquals(LocalDateTime.of(2024,3,1,0,0), result[0]);
        assertEquals(LocalDateTime.of(2024,3,31,23,59,59,999999999), result[1]);
    }

    @Test
    public void deveResolverPeriodoAnual() {

        LocalDateTime inicio = LocalDateTime.of(2023,8,10,12,0);

        LocalDateTime[] result =
                PeriodoResolver.resolver(inicio,null, TipoRelatorio.ANUAL);

        assertEquals(LocalDateTime.of(2023,1,1,0,0), result[0]);
        assertEquals(LocalDateTime.of(2023,12,31,23,59,59,999999999), result[1]);
    }

    @Test
    public void deveRetornarPeriodoQuandoTipoPeriodo() {

        LocalDateTime inicio = LocalDateTime.of(2025,5,1,10,0);
        LocalDateTime fim = LocalDateTime.of(2025,5,10,18,0);

        LocalDateTime[] result =
                PeriodoResolver.resolver(inicio,fim, TipoRelatorio.PERIODO);

        assertEquals(inicio,result[0]);
        assertEquals(fim,result[1]);
    }

    @Test
    public void deveCairNoDefaultQuandoTipoDesconhecido() {

        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fim = inicio.plusDays(1);

        LocalDateTime[] result =
                PeriodoResolver.resolver(inicio,fim, TipoRelatorio.PERIODO);

        assertEquals(inicio,result[0]);
        assertEquals(fim,result[1]);
    }
}