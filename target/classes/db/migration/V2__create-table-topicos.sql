create table topicos (
    id bigint not null auto_increment,
    usuario_id bigint not null,
    titulo varchar(100) not null,
    mensaje varchar(200) not null,
    nombre_curso varchar(255) not null,
    status  varchar(100) not null,
    fecha datetime not null,
    primary key(id),
    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id)
);