/* Database: SqlServer. Generation date: 2026-02-19 11:18:59:888 */
/* Entity Peca */
create table peca (
	id UNIQUEIDENTIFIER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	codigo_desenho VARCHAR(255) NOT NULL /* codigoDesenho */,
	tempo_estimado_minutos NUMERIC(19) NOT NULL /* tempoEstimadoMinutos */,
	status VARCHAR(255) NOT NULL,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Entity Funcionario */
create table funcionario (
	id UNIQUEIDENTIFIER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	matricula VARCHAR(255) NOT NULL,
	cargo VARCHAR(255) NOT NULL,
	turno VARCHAR(255) NOT NULL,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Entity Maquina */
create table maquina (
	id UNIQUEIDENTIFIER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Entity Registro_producao */
create table registroproducao (
	id UNIQUEIDENTIFIER NOT NULL,
	peca UNIQUEIDENTIFIER,
	funcionario UNIQUEIDENTIFIER,
	maquina UNIQUEIDENTIFIER,
	data_inicio DATETIME NOT NULL /* dataInicio */,
	data_final DATETIME NOT NULL /* dataFinal */,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Join Tables */

/* Primary Key Constraints */
alter table peca add constraint pk_peca_id primary key(id);
alter table funcionario add constraint pk_funcionario_id primary key(id);
alter table maquina add constraint pk_maquina_id primary key(id);
alter table registroproducao add constraint pk_registroproducao_id primary key(id);

/* Foreign Key Constraints */
alter table registroproducao add constraint fkpy9btbqphm8robupivfdak5ligyd foreign key (peca) references peca (id);
alter table registroproducao add constraint fkvs90u0qh47hh4dqsmjgkewlm6frf foreign key (funcionario) references funcionario (id);
alter table registroproducao add constraint fk3clg22zb1wh7fd2j396k8kbp1xx4 foreign key (maquina) references maquina (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
