create table produtos(

    id  bigint not null auto_increment,
    nome varchar(150) not null,
    valor   decimal(7, 2) not null,

    primary key(id)
);