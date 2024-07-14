create table posts(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha datetime not null,

    primary key(id)

);