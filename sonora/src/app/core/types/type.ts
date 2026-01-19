export interface SalaInterface {
    id: number
    nome: string
    capacidade: number
};

enum TipoInstrumento {
    CORDAS,
    SOPROS,
    PERCUSSAO,
    ELETRPOFONES
}

export interface InstrumentoInterface {
    id: number
    tipoInstrumeto: TipoInstrumento
    nome: string
    modelo: string
    numeroSerie: string
    anoFabricacao: number
    paisOrigem: string
    estadoConservacao: string
    caracteristica: string
    salaFixaId: SalaInterface
};

export interface UsuarioInterface {
    login: string
    senha: string
    email: string
};

export interface EnderecoInterface {
    logradouro: string 
    bairro: string 
    cep: string 
    numero: string 
    complemento: string 
    cidade: string 
    uf: string 
}

export interface MembroInterface {
    id: number
    usuario: UsuarioInterface
    cpf: string
    dataNascimento: Date
    nome: string
    email: string
    endereco: EnderecoInterface
    telefone: string
};


enum TipoUso {
    AULA,
    ENSAIO_BANDA,
    ENSAIO_ORQUESTRA,
    ESTUDO_GRUPO,
    ESTUDO_INDIVIDUAL
};

export interface ReservaInterface {
    id: number
    sala: SalaInterface
    instrumento: InstrumentoInterface
    membro: MembroInterface
    dataHoraInicio: Date
    dataHoraFim: Date
    dataHoraRegistro: Date
    emEspera: boolean
    tipoUso: TipoUso
    observacoes: string
};
