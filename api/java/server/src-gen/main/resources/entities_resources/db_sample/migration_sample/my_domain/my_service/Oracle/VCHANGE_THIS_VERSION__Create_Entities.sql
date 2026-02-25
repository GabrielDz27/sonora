/* Database: Oracle. Generation date: 2026-02-24 20:05:28:376 */
/* Entity Peca */
create table peca (
	id RAW(16) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	codigo_desenho VARCHAR(50) NOT NULL /* codigoDesenho */,
	tempo_estimado_minutos NUMBER(19) NOT NULL /* tempoEstimadoMinutos */,
	status VARCHAR(255) NOT NULL,
	valor DECIMAL NOT NULL,
	motivo_perda VARCHAR(255) NOT NULL /* motivoPerda */,
	ext CLOB,
	CONSTRAINT peca_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX peca_ext ON peca (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Entity Funcionario */
create table funcionario (
	id RAW(16) NOT NULL,
	nome VARCHAR(255) NOT NULL,
	matricula VARCHAR(20) NOT NULL,
	cargo VARCHAR(255) NOT NULL,
	turno VARCHAR(255) NOT NULL,
	ativo NUMBER(1) NOT NULL,
	username VARCHAR(255) NOT NULL,
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

/* Entity RegistroProducao */
create table registro_producao (
	id RAW(16) NOT NULL,
	peca RAW(16),
	funcionario RAW(16),
	maquina RAW(16),
	data_inicio TIMESTAMP NOT NULL /* dataInicio */,
	data_final TIMESTAMP /* dataFinal */,
	ext CLOB,
	CONSTRAINT registro_producao_JSON_ext CHECK (ext IS JSON)
);


/* Creating index for customization column */
CREATE INDEX registro_producao_ext ON registro_producao (ext) INDEXTYPE IS CTXSYS.CONTEXT PARAMETERS ('section group CTXSYS.JSON_SECTION_GROUP SYNC (ON COMMIT)');

/* Join Tables */

/* Primary Key Constraints */
alter table peca add constraint pk_peca_id primary key(id);
alter table funcionario add constraint pk_funcionario_id primary key(id);
alter table maquina add constraint pk_maquina_id primary key(id);
alter table registro_producao add constraint pk_registro_producao_id primary key(id);

/* Foreign Key Constraints */
alter table registro_producao add constraint fktmw4op7p2yzaybfjej4wrlw7uncv foreign key (peca) references peca (id);
alter table registro_producao add constraint fk5bcbtdx1prkvyhastli4bjgls1g7 foreign key (funcionario) references funcionario (id);
alter table registro_producao add constraint fkrrmgosxbgd2t7mnbb0qkzuankgr4 foreign key (maquina) references maquina (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
