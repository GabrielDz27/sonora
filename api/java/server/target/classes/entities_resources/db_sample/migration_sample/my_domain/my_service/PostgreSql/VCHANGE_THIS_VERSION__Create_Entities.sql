/* Database: PostgreSql. Generation date: 2026-02-24 10:39:52:349 */
/* Entity Peca */
create table peca (
	id UUID NOT NULL,
	nome VARCHAR(100) NOT NULL,
	codigo_desenho VARCHAR(50) NOT NULL /* codigoDesenho */,
	tempo_estimado_minutos NUMERIC(19) NOT NULL /* tempoEstimadoMinutos */,
	status VARCHAR(255) NOT NULL,
	valor DECIMAL NOT NULL,
	motivo_perda VARCHAR(255) NOT NULL /* motivoPerda */,
	ext JSONB
);


/* Creating index for customization column */
create index peca_ext on peca using gin (ext);

/* Entity Funcionario */
create table funcionario (
	id UUID NOT NULL,
	nome VARCHAR(255) NOT NULL,
	matricula VARCHAR(20) NOT NULL,
	cargo VARCHAR(255) NOT NULL,
	turno VARCHAR(255) NOT NULL,
	ativo BOOLEAN NOT NULL,
	username VARCHAR(255) NOT NULL,
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

/* Entity RegistroProducao */
create table registro_producao (
	id UUID NOT NULL,
	peca UUID,
	funcionario UUID,
	maquina UUID,
	data_inicio TIMESTAMP NOT NULL /* dataInicio */,
	data_final TIMESTAMP /* dataFinal */,
	ext JSONB
);


/* Creating index for customization column */
create index registro_producao_ext on registro_producao using gin (ext);

/* Join Tables */

/* Primary Key Constraints */
alter table peca add constraint pk_peca_id primary key(id);
alter table funcionario add constraint pk_funcionario_id primary key(id);
alter table maquina add constraint pk_maquina_id primary key(id);
alter table registro_producao add constraint pk_registro_producao_id primary key(id);

/* Foreign Key Constraints */
alter table registro_producao add constraint fkykydbz0lvtvn8g4ebjq1jrshp6x9 foreign key (peca) references peca (id);
alter table registro_producao add constraint fkqoqdceemmjmcocxljow88e4qr31j foreign key (funcionario) references funcionario (id);
alter table registro_producao add constraint fkmanbn2h0ejmeeh4pbemfzej2uir7 foreign key (maquina) references maquina (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
