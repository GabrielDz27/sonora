export interface RelatorioQuery {
    dataInicio: string;
    dataFinal: string;
    tipoRelatorio: 'PERIODO' | 'MENSAL' | 'ANALITICO'; 
    turno?: string;
    funcionario?: string[]; 
    maquina?: string[];
    codigoDesenho?: string[];
}

export interface MaquinaRelatorio {
  id: string;
  nome: string;
  _discriminator?: string;
}

export interface MaquinaTrabalhandoRelatorio {
  maquina?: MaquinaRelatorio;
  horas: number;
}

export interface PecaFuncionarioRelatorio {
  peca?: { id: string; nome: string };
  funcionario?: { id: string; nome: string };
  maquina?: MaquinaRelatorio;
}

export interface RetornoRelatorio {
  maquinaTrabalhando?: MaquinaTrabalhandoRelatorio[];
  pecaMortas: number;
  pecaFuncionario?: PecaFuncionarioRelatorio[];
}

export interface RelatorioResponse {
  retorno: RetornoRelatorio[];
}
