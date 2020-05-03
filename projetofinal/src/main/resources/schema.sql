drop table if exists champion;

create table champion(
    id_champion bigint auto_increment not null,
    nome varchar(255) null,
    cidade_natal varchar(50) null,
    funcao varchar(30) null,
    dificuldade varchar(30) null,
    primary key(id_champion));