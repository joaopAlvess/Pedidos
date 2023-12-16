create table clientes(

    id  bigint not null auto_increment,
    nome    varchar(150) not null,
    endereco    varchar(150),
    telefone    varchar(150),
    valor_adicional     varchar(150),
    ativo tinyint,


    primary key(id)
);