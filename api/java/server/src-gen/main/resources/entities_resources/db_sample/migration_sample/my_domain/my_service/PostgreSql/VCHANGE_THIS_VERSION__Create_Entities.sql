/* Database: PostgreSql. Generation date: 2026-02-19 11:18:59:871 */
/* Entity Peca */
create table peca (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL,
	codigo_desenho VARCHAR(255) NOT NULL /* codigoDesenho */,
	tempo_estimado_minutos NUMERIC(19) NOT NULL /* tempoEstimadoMinutos */,
	status VARCHAR(255) NOT NULL,
	ext JSONB
);


/* Creating index for customization column */
create index peca_ext on peca using gin (ext);

/* Entity Funcionario */
create table funcionario (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL,
	matricula VARCHAR(255) NOT NULL,
	cargo VARCHAR(255) NOT NULL,
	turno VARCHAR(255) NOT NULL,
	ext JSONB
);


/* Creating index for customization column */
create index funcionario_ext on funcionario using gin (ext);

/* Entity Maquina */
create table maquina (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL,
	ext JSONB
);


/* Creating index for customization column */
create index maquina_ext on maquina using gin (ext);

/* Entity Registro_producao */
create table registroproducao (
	id UUID NOT NULL,
	peca UUID,
	funcionario UUID,
	maquina UUID,
	data_inicio TIMESTAMP NOT NULL /* dataInicio */,
	data_final TIMESTAMP NOT NULL /* dataFinal */,
	ext JSONB
);


/* Creating index for customization column */
create index registroproducao_ext on registroproducao using gin (ext);

/* Join Tables */

/* Primary Key Constraints */
alter table peca add constraint pk_peca_id primary key(id);
alter table funcionario add constraint pk_funcionario_id primary key(id);
alter table maquina add constraint pk_maquina_id primary key(id);
alter table registroproducao add constraint pk_registroproducao_id primary key(id);

/* Foreign Key Constraints */
alter table registroproducao add constraint fkvelizugnqhb0zozz6qdcix3taxut foreign key (peca) references peca (id);
alter table registroproducao add constraint fkv0axhzbch76rrxirrw53h6vapvq8 foreign key (funcionario) references funcionario (id);
alter table registroproducao add constraint fktri88qci6ivrcwcx3kksygqvudgq foreign key (maquina) references maquina (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
