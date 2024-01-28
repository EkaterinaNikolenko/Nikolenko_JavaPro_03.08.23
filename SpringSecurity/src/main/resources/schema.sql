drop table if exists users CASCADE;
create table users
(
    id       bigserial primary key,
    status   varchar(10),
    password varchar(255),
    username varchar(255) unique
);

drop table if exists products CASCADE;
create table products
(
    id     bigserial primary key,
    name   varchar(255) unique,
    cost   decimal(5, 2)
);