export type UsuarioVM = {
    nome: string;
    id: string;
}

export type turno = 'PRIMEIRO' | 'SEGUNDO' | 'TERCEIRO' | 'DIURNO';

export interface FuncionarioDto {
    id?: string;
    nome: string;
    matricula: string;
    cargo: string;
    turno: turno;
    ativo: boolean;
    username: string;
}