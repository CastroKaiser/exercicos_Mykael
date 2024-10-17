create database projeto_17;
use projeto_17;

create table cliente (
	id_cliente int primary key not null auto_increment,
    nome_cliente varchar(45),
    cpf varchar(12),
    email varchar(45)
);

insert into cliente (nome_cliente,cpf,email)
values ("Paulo","11111111111","paulo@hotmail.com"),
	   ("Jose","22222222222","jose@hotmail.com"),
       ("Mauro","33333333333","mauro@hotmail.com");
       


