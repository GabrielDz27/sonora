/* Database: SqlServer. Generation date: 2026-02-20 16:56:01:446 */
/* Entity Peca */
create table peca (
	id UNIQUEIDENTIFIER NOT NULL,
	nome VARCHAR(100) NOT NULL,
	codigo_desenho VARCHAR(50) NOT NULL /* codigoDesenho */,
	tempo_estimado_minutos NUMERIC(19) NOT NULL /* tempoEstimadoMinutos */,
	status VARCHAR(255) NOT NULL,
	valor MONEY NOT NULL,
	motivo_perda VARCHAR(255) NOT NULL /* motivoPerda */,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Entity Funcionario */
create table funcionario (
	id UNIQUEIDENTIFIER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	matricula VARCHAR(20) NOT NULL,
	cargo VARCHAR(255) NOT NULL,
	turno VARCHAR(255) NOT NULL,
	ativo BIT NOT NULL,
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

/* Entity RegistroProducao */
create table registro_producao (
	id UNIQUEIDENTIFIER NOT NULL,
	peca UNIQUEIDENTIFIER,
	funcionario UNIQUEIDENTIFIER,
	maquina UNIQUEIDENTIFIER,
	data_inicio DATETIME NOT NULL /* dataInicio */,
	data_final DATETIME /* dataFinal */,
	ext VARCHAR(4000)
);


/* Creating index for customization column */
/* column type JSON not supported */

/* Join Tables */

/* Primary Key Constraints */
alter table peca add constraint pk_peca_id primary key(id);
alter table funcionario add constraint pk_funcionario_id primary key(id);
alter table maquina add constraint pk_maquina_id primary key(id);
alter table registro_producao add constraint pk_registro_producao_id primary key(id);

/* Foreign Key Constraints */
alter table registro_producao add constraint fk6sjntdsldeuyibgj4nzodbdbjwqz foreign key (peca) references peca (id);
alter table registro_producao add constraint fkvzors6xfqrl4tqm5rcsu1qplqcja foreign key (funcionario) references funcionario (id);
alter table registro_producao add constraint fkvvad7bvfer24cnxg0zawq9pjqrsa foreign key (maquina) references maquina (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
