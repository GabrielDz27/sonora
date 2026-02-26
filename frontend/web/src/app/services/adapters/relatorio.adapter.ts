import { RelatorioResponse } from '../../models/relatorio.models';
import { RelatorioView } from '../../models/relatorio-view.models';

export function mapRelatorio(res: RelatorioResponse): RelatorioView {

  const rankingMaquinas = new Map<string, any>();
  const funcionarios = new Map<string, any>();

  let totalMortas = 0;
  const analitico: any[] = [];

  res.retorno.forEach(item => {

    totalMortas += item.pecaMortas ?? 0;

    // maquinas
    if (item.maquinaTrabalhando?.maquina) {
      const m = item.maquinaTrabalhando.maquina;
      const atual = rankingMaquinas.get(m.id) ?? { id: m.id, nome: m.nome, horas: 0 };
      atual.horas += item.maquinaTrabalhando.horas;
      rankingMaquinas.set(m.id, atual);
    }

    // funcionarios
    if (item.pecaFuncionario?.funcionario) {
      const f = item.pecaFuncionario.funcionario;
      const atual = funcionarios.get(f.id) ?? { id: f.id, nome: f.nome, pecas: 0 };
      atual.pecas++;
      funcionarios.set(f.id, atual);
    }

    // analitico
    if (item.pecaFuncionario) {
      analitico.push({
        maquina: item.maquinaTrabalhando?.maquina?.nome ?? '-',
        funcionario: item.pecaFuncionario.funcionario?.nome ?? '-',
        peca: item.pecaFuncionario.peca?.nome ?? '-'
      });
    }

  });

  return {
    totalPecasMortas: totalMortas,
    rankingMaquinas: [...rankingMaquinas.values()].sort((a,b)=>b.horas-a.horas),
    producaoFuncionario: [...funcionarios.values()].sort((a,b)=>b.pecas-a.pecas),
    analitico
  };
}