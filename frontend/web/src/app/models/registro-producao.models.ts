export interface RegistroProducaoDto {
    id?: string;
    peca?: string;
    funcionario?: string;
    maquina?: string;
    dataInicio: Date | string;
    dataFinal?: Date | string;
}