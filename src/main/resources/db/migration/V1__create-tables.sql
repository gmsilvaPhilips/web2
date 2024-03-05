

create table comandas(
                    id bigint not null auto_increment,
                    idUsuario bigint not null,
                    nomeUsuario varchar(100) not null,
                    telefoneUsuario varchar(11) not null,
                    primary key(id)
);


create table produtos(
                         id bigint not null,
                         nome varchar(100) not null,
                         preco decimal(19,2) not null,
                         idComanda bigint not null,
                         foreign key (idComanda) references comandas(id)
);