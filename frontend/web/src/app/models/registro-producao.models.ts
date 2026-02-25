export interface RegistroProducaoDto {
    id?: string;
    peca: pecaId;
    funcionario: funcionarioId;
    maquina: maquinaId;
    dataInicio: Date | string;
    dataFinal?: Date | string;
}

export interface funcionarioId {
    id: string;
}

export interface maquinaId {
    id: string;
}

export interface pecaId {
    id: string;
}