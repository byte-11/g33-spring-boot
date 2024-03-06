create table article
(
    id      bigserial primary key,
    title   varchar,
    content text,
    author  varchar,
    date    date
);
