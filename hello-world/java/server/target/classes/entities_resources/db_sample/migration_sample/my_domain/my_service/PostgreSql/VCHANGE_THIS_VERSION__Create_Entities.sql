/* Database: PostgreSql. Generation date: 2026-02-12 14:39:21:509 */
/* Entity Convidado */
create table convidado (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL,
	nome_social VARCHAR(255) /* nomeSocial */,
	cpf VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL /* dataNascimento */,
	ext JSONB
);


/* Creating index for customization column */
create index convidado_ext on convidado using gin (ext);

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

/* Entity Ingresso */
create table ingresso (
	id UUID NOT NULL,
	data_hora TIMESTAMP /* dataHora */,
	convidado UUID,
	quantidade_acompanhantes NUMERIC(19) NOT NULL /* quantidadeAcompanhantes */,
	evento UUID NOT NULL,
	ext JSONB
);


/* Creating index for customization column */
create index ingresso_ext on ingresso using gin (ext);

/* Entity Atracao */
create table atracao (
	id UUID NOT NULL,
	nome VARCHAR(30) NOT NULL,
	data_hora TIMESTAMP /* dataHora */,
	local VARCHAR(30) NOT NULL,
	evento UUID,
	ext JSONB
);


/* Creating index for customization column */
create index atracao_ext on atracao using gin (ext);

/* Join Tables */

/* Primary Key Constraints */
alter table convidado add constraint pk_convidado_id primary key(id);
alter table evento add constraint pk_evento_id primary key(id);
alter table ingresso add constraint pk_ingresso_id primary key(id);
alter table atracao add constraint pk_atracao_id primary key(id);

/* Foreign Key Constraints */
alter table ingresso add constraint fkftfbzonsnerjizke9a3g7dbd7qgx foreign key (convidado) references convidado (id);
alter table ingresso add constraint fkgvq04wdxho6to4qf8divrohbg6jt foreign key (evento) references evento (id);
alter table atracao add constraint fkgn1n9pwg5mfphehxafzqz77wadeg foreign key (evento) references evento (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
