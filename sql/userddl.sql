create table users
(
    id         bigint generated by default as identity,
    user_id    varchar(255),
    user_pw    varchar(255),
    user_name  varchar(255),
    user_email varchar(255),
    primary key (id)
);