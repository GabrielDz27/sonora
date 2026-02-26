package br.com.senior.mydomain.myservice.services.relatorio;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import br.com.senior.mydomain.myservice.services.util.RelatorioFiltro;
import br.com.senior.mydomain.myservice.services.util.RelatorioFiltroMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class RelatorioService {

    @Inject
    private RegistroProducaoRepository registroRepo;

    @Inject
    private MaquinaRepository maquinaRepo;

    @Inject
    private PecaRepository pecaRepo;

    public List<RetornoRelatorio> retornaDados(RelatorioInput request){

        RelatorioFiltro filtro = RelatorioFiltroMapper.fromInput(request);

        List<MaquinaTrabalhando> maquinas =
                maquinaRepo.maquinaTrabalhada(
                        filtro.inicio,
                        filtro.fim,
                        filtro.maquinas
                );

        Long pecasMortas =
                pecaRepo.countPecaMorta(
                        filtro.inicio,
                        filtro.fim,
                        filtro.desenhos
                );

        List<PecaFuncionario> porFuncionario =
                registroRepo.pecaPorFuncionario(
                        filtro.inicio,
                        filtro.fim,
                        filtro.funcionarios,
                        filtro.turno
                );

        RetornoRelatorio r = new RetornoRelatorio();
        r.maquinaTrabalhando = maquinas;
        r.pecaMortas = (long) pecasMortas.intValue();
        r.pecaFuncionario = porFuncionario;

        return List.of(r);
    }
}
