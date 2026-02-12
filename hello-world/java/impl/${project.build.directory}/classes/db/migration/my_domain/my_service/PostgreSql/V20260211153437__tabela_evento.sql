
/* Entity Evento */
create table evento (
	id UUID NOT NULL,
	nome VARCHAR(30) NOT NULL,
	lotacao_maxima NUMERIC(19) NOT NULL /* lotacaoMaxima */,
	data_hora TIMESTAMP NOT NULL /* dataHora */,
	endereco VARCHAR(50) NOT NULL,
	tipoentradaevento VARCHAR(255),
	ext JSONB
);


/* Creating index for customization column */
create index evento_ext on evento using gin (ext);
alter table evento add constraint pk_evento_id primary key(id);
