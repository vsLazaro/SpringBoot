drop table if exists cliente;

create table cliente(
    id_cliente bigint auto_increment not null,
    nome varchar(255) null,
    renda double null,
    primary key(id_cliente));