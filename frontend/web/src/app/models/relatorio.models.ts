export interface RelatorioQuery {
    dataInicio: string; // ISO DateTime
    dataFinal: string;
    tipoRelatorio: 'PERIODO' | 'MENSAL' | 'ANALITICO'; // Ajuste conforme seu Enum
    turno?: string;
    funcionario?: string[]; // O "*" do Java vira Array
    maquina?: string[];
    codigoDesenho?: string[];
}

export interface RetornoRelatorio {
  maquinaTrabalhando?: {
    maquina?: { id: string; nome: string };
    horas: number;
  };
  pecaMortas: number;
  pecaFuncionario?: {
    peca?: { id: string; nome: string };
    funcionario?: { id: string; nome: string };
  };
}

export interface RelatorioResponse {
  retorno: RetornoRelatorio[];
}