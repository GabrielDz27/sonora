import { RelatorioResponse } from '../../models/relatorio.models';
import { RelatorioView } from '../../models/relatorio-view.models';

export function mapRelatorio(res: RelatorioResponse): RelatorioView {

  const rankingMaquinas = new Map<string, { id: string; nome: string; horas: number }>();
  const funcionarios = new Map<string, { id: string; nome: string; pecas: number }>();

  let totalMortas = 0;
  const analitico: RelatorioView['analitico'] = [];

  (res.retorno ?? []).forEach(item => {

    totalMortas += item.pecaMortas ?? 0;

    const maquinasTrabalhando = item.maquinaTrabalhando ?? [];

    maquinasTrabalhando.forEach(maquinaTrabalhando => {
      const maquina = maquinaTrabalhando.maquina;
      if (!maquina?.id) return;

      const atual = rankingMaquinas.get(maquina.id) ?? { id: maquina.id, nome: maquina.nome, horas: 0 };
      atual.horas += maquinaTrabalhando.horas ?? 0;
      rankingMaquinas.set(maquina.id, atual);
    });

    const maquinaFallback = maquinasTrabalhando.find(x => x.maquina?.nome)?.maquina?.nome ?? '-';

    (item.pecaFuncionario ?? []).forEach(pecaFuncionario => {
      const funcionario = pecaFuncionario.funcionario;
      if (funcionario?.id) {
        const atual = funcionarios.get(funcionario.id) ?? { id: funcionario.id, nome: funcionario.nome, pecas: 0 };
        atual.pecas += 1;
        funcionarios.set(funcionario.id, atual);
      }

      analitico.push({
        maquina: pecaFuncionario.maquina?.nome ?? maquinaFallback,
        funcionario: pecaFuncionario.funcionario?.nome ?? '-',
        peca: pecaFuncionario.peca?.nome ?? '-'
      });
    });

  });

  return {
    totalPecasMortas: totalMortas,
    rankingMaquinas: [...rankingMaquinas.values()].sort((a, b) => b.horas - a.horas),
    producaoFuncionario: [...funcionarios.values()].sort((a, b) => b.pecas - a.pecas),
    analitico
  };
}
