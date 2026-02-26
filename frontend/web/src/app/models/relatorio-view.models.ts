export interface RelatorioView {
  totalPecasMortas: number;
  rankingMaquinas: RankingMaquina[];
  producaoFuncionario: RankingFuncionario[];
  analitico: LinhaAnalitica[];
}

export interface RankingMaquina {
  id: string;
  nome: string;
  horas: number;
}

export interface RankingFuncionario {
  id: string;
  nome: string;
  pecas: number;
}

export interface LinhaAnalitica {
  maquina: string;
  funcionario: string;
  peca: string;
}