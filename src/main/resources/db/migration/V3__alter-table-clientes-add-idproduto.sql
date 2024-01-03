alter table clientes
add column produto_id bigint,
add foreign key (produto_id) references produtos(id);
