insert into pessoas (nome_completo , telefone , dt_nascimento , email , sexo , tecnologia , escolaridade )
values('Luiz Maia', '999333002', '1987-07-21', 'luiz@gmail.com', 'm', '', '');

select * from pessoas ;

select nome_completo, email from pessoas ;

update pessoas set senha = '123' ;