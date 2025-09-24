create table users(
 id int primary key,
 name text,
 email text,
 age int,
 created_at date
);

insert into users(id, name, email, age, created_at) values
(1, 'Ivan', 'Ivan@mail.ru', 22, '2025.09.10'),
(2, 'Aleksey', 'Aleksey@mail.ru', 32, '2025.10.10'),
(3, 'Elena', 'Elena@mail.ru', 18, '2025.10.21');