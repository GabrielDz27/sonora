export type statusPeca = 'PENDENTE' | 'PROCESSO' | 'FINALIZADO' | 'MORTA'

export interface MudarStatusPeca {
    id: string
    status: statusPeca
}

export interface PecaDto {
    id?: string;
    nome: string;
    codigoDesenho: string;
    tempoEstimadoMinutos: number;
    status: statusPeca;
    valor: number;
    motivoPerda?: string;
}