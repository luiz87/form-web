CREATE TABLE pessoas (
	id SERIAL ,--int  primary key,
	nome_completo varchar(255),
	telefone varchar(255),
	dt_nascimento varchar(255),
	email varchar(255),
	sexo varchar(255),
	tecnologia varchar(255),
	escolaridade varchar(255)
);


ALTER TABLE pessoas ADD senha varchar(100);

alter table pessoas add uf varchar(2);

alter table pessoas alter column "dt_nascimento" type date using ("dt_nascimento"::text::date);

ALTER TABLE pessoas ADD CONSTRAINT uk_email UNIQUE (email);