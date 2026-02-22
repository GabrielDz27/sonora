"Interface base para peças seguindo o schema do banco"
export interface Peca {
    id?: string; // UUID
    nome: string;
    codigoDesenho: string;
    tempoEstimadoMinutos: number;
    status: 'PENDENTE' | 'PROCESSO' | 'FINALIZADO' | 'MORTA';
    valor: number;
    motivo_perda?: string;
    ext?: any; // Para o campo JSONB
}

"Interface para os colaboradores"
export interface Funcionario {
    id?: string;
    nome: string;
    matricula: string;
    cargo: string;
    turno: 'MANHA' | 'TARDE' | 'NOITE';
    ativo: boolean;
}

"Interface para as máquinas do chão de fábrica"
export interface Maquina {
    id?: string;
    nome: string;
    status: 'ATIVO' | 'MANUTENCAO' | 'INATIVO';
}

"Interface mestre de apontamento"
export interface RegistroProducao {
    id?: string;
    peca: string | Peca; // ID no envio, Objeto no retorno
    funcionario: string | Funcionario;
    maquina: string | Maquina;
    dataInicio: Date | string;
    dataFinal?: Date | string;
}