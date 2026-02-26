package br.com.senior.mydomain.myservice.services.util;

import br.com.senior.mydomain.myservice.RelatorioInput;
import br.com.senior.mydomain.myservice.TurnoFuncionario;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class RelatorioFiltroMapper {

    public static RelatorioFiltro fromInput(RelatorioInput in) {

        LocalDateTime inicio = in.dataInicio == null
                ? null
                : LocalDateTime.ofInstant(in.dataInicio, ZoneId.systemDefault());

        LocalDateTime fim = in.dataFinal == null
                ? null
                : LocalDateTime.ofInstant(in.dataFinal, ZoneId.systemDefault());

        LocalDateTime[] periodo =
                PeriodoResolver.resolver(
                        inicio,
                        fim,
                        in.tipoRelatorio
                );


        RelatorioFiltro f = new RelatorioFiltro();
        f.inicio = periodo[0];
        f.fim = periodo[1];
        f.turno = String.valueOf(in.turno);
        f.funcionarios = in.funcionario;
        f.maquinas = in.maquina;
        f.desenhos = in.codigoDesenho;

        return f;
    }
}