export type statusMaquina = 'ATIVO' | 'MANUTENCAO' | 'INATIVO';

export interface MaquinaDto {
    id?: string;
    nome: string;
    status: statusMaquina;
}