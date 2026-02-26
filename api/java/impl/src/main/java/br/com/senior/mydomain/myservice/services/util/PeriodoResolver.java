package br.com.senior.mydomain.myservice.services.util;

import br.com.senior.mydomain.myservice.TipoRelatorio;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class PeriodoResolver {

    public static LocalDateTime[] resolver(LocalDateTime inicio, LocalDateTime fim, TipoRelatorio tipo){

        if(tipo == null) return new LocalDateTime[]{inicio,fim};

        switch (tipo){

            case MENSAL:
                LocalDate primeiroDiaMes = inicio.toLocalDate().withDayOfMonth(1);
                LocalDate ultimoDiaMes = inicio.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());

                return new LocalDateTime[]{
                        primeiroDiaMes.atStartOfDay(),
                        ultimoDiaMes.atTime(LocalTime.MAX)
                };

            case ANUAL:
                LocalDate primeiroAno = inicio.toLocalDate().withDayOfYear(1);
                LocalDate ultimoAno = inicio.toLocalDate().with(TemporalAdjusters.lastDayOfYear());

                return new LocalDateTime[]{
                        primeiroAno.atStartOfDay(),
                        ultimoAno.atTime(LocalTime.MAX)
                };

            case PERIODO:
            default:
                return new LocalDateTime[]{inicio,fim};
        }
    }
}