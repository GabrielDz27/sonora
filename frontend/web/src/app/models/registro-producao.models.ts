export interface RegistroProducaoDto {
    id?: string;
    peca: PecaId;
    funcionario: FuncionarioId;
    maquina: MaquinaId;
    dataInicio: Date | string;
    dataFinal?: Date | string;
}

export interface FuncionarioId {
    id: string;
}

export interface MaquinaId {
    id: string;
}

export interface PecaId {
    id: string;
}

export interface RegistroProducaoPaginaDto {
    id?: string;
    peca: string;
    funcionario: string;
    maquina: string;
    dataInicio: Date | string;
    dataFinal?: Date | string;
}

export interface RegistroProducaoDetalhadoDto {
  id: string;
  peca: {
    id: string;
    nome: string;
    codigoDesenho: string;
    tempoEstimadoMinutos: number;
    status: 'PENDENTE' | 'PROCESSO' | 'FINALIZADO' | 'MORTA';
    valor: number;
    motivoPerda: string;
    _discriminator: 'peca';
  };
  funcionario: {
    id: string;
    nome: string;
    matricula: string;
    cargo: string;
    turno: 'PRIMEIRO' | 'SEGUNDO' | 'TERCEIRO' | 'DIURNO';
    ativo: boolean;
    username: string;
    _discriminator: 'funcionario';
  };
  maquina: {
    id: string;
    nome: string;
    status: 'ATIVO' | 'MANUTENCAO' | 'INATIVO';
    _discriminator: 'maquina';
  };
  dataInicio: string; 
  dataFinal?: string; 
}

export interface RetornoRegistroProducaoResponse {
  retorno: RegistroProducaoDetalhadoDto[];
}