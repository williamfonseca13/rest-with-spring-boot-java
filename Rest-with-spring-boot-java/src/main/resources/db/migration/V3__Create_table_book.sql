create table if not exists book (
    id bigserial primary key,
    author varchar(100) not null,
    launch_date DATE,
    price decimal,
    title text
    );