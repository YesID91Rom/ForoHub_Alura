create table usuarios(
        id bigint not null auto_increment,
        email varchar(100) not null,
        clave varchar(300) not null UNIQUE,
        primary key(id)
);
-- Inserting a record into the 'autorxs' table
INSERT INTO usuarios (id, email, clave) VALUES
(1, 'yesid@example.com', '$2a$10$GK8QwgscUkOopXtDaX0hweGLRNgfOGpcT6/P5W3cJ1NMt3.K.ozAa');
