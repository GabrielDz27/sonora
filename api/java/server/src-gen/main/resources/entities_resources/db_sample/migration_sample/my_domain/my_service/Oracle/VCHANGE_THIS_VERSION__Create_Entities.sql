/* Database: Oracle. Generation date: 2026-02-19 11:18:59:891 */
/* Entity Peca */
create table peca (
	id RAW(16) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	codigo_desenho VARCHAR(255) NOT NULL /* codigoDesenho */,
	tempo_estimado_minutos NUMBER(19) NOT NULL /* tempoEstimadoMinutos */,
	status VARCHAR(255) NOT NULL,
	ext CLOB,
	CONSTRAINT peca_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX peca_ext ON peca (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Entity Funcionario */
create table funcionario (
	id RAW(16) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	matricula VARCHAR(255) NOT NULL,
	cargo VARCHAR(255) NOT NULL,
	turno VARCHAR(255) NOT NULL,
	ext CLOB,
	CONSTRAINT funcionario_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX funcionario_ext ON funcionario (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Entity Maquina */
create table maquina (
	id RAW(16) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL,
	ext CLOB,
	CONSTRAINT maquina_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX maquina_ext ON maquina (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Entity Registro_producao */
create table registroproducao (
	id RAW(16) NOT NULL,
	peca RAW(16),
	funcionario RAW(16),
	maquina RAW(16),
	data_inicio TIMESTAMP NOT NULL /* dataInicio */,
	data_final TIMESTAMP NOT NULL /* dataFinal */,
	ext CLOB,
	CONSTRAINT registroproducao_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX registroproducao_ext ON registroproducao (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Join Tables */

/* Primary Key Constraints */
alter table peca add constraint pk_peca_id primary key(id);
alter table funcionario add constraint pk_funcionario_id primary key(id);
alter table maquina add constraint pk_maquina_id primary key(id);
alter table registroproducao add constraint pk_registroproducao_id primary key(id);

/* Foreign Key Constraints */
alter table registroproducao add constraint fkdumyu8cdz70jckme1mb5ozg7s4te foreign key (peca) references peca (id);
alter table registroproducao add constraint fkbp9m1bdf4fwmr7wcq6x9uycilze7 foreign key (funcionario) references funcionario (id);
alter table registroproducao add constraint fkx5yaqdkq1dmsmwztddu2kwteop9l foreign key (maquina) references maquina (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
