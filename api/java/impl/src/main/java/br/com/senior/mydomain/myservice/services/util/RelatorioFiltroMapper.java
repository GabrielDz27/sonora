package br.com.senior.mydomain.myservice.services.util;

import br.com.senior.mydomain.myservice.RelatorioInput;
import br.com.senior.mydomain.myservice.TurnoFuncionario;

import java.time.LocalDateTime;

public class RelatorioFiltroMapper {

    public static RelatorioFiltro fromInput(RelatorioInput in){

        LocalDateTime[] periodo =
                PeriodoResolver.resolver(
                        LocalDateTime.from(in.dataInicio),
                        LocalDateTime.from(in.dataFinal),
                        in.tipoRelatorio
                );

        RelatorioFiltro f = new RelatorioFiltro();
        f.inicio = periodo[0];
        f.fim = periodo[1];
        f.turno = String.valueOf(TurnoFuncionario.valueOf(String.valueOf(in.turno)));
        f.funcionarios = in.funcionario;
        f.maquinas = in.maquina;
        f.desenhos = in.codigoDesenho;

        return f;
    }
}