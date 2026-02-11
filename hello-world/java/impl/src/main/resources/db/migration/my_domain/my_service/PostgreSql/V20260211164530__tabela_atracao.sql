
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

alter table atracao add constraint pk_atracao_id primary key(id);
alter table atracao add constraint fk4fvhkckocl8gsrxwcwis978qjhyj foreign key (evento) references evento (id);
