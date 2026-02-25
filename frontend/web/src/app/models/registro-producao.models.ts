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