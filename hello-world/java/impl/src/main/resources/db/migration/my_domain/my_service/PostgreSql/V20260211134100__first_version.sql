/* Database: PostgreSql. Generation date: 2026-02-11 15:03:01:414 */
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

/* Join Tables */

/* Primary Key Constraints */
alter table convidado add constraint pk_convidado_id primary key(id);

/* Foreign Key Constraints */

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
