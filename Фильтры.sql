create table type(
    id serial primary key,
    name varchar(255)
);
create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
	expired_date date,
	price money
);

update type set name = 'МОРОЖЕННОЕ'
where id = 3;
update type set name = 'МОЛОКО'
where id = 2;
update type set name = 'СЫР'
where id = 1;
update type set name = 'ИНДЕЙКА'
where id = 4;


select * from product;
select * from type;
--заполнение таблиц
insert into type(id, name) values (1, 'СЫР');
insert into type(id, name) values (2, 'МОЛОКО');
insert into type(id, name) values (3, 'МОРОЖЕНОЕ');
insert into type(id, name) values (4, 'ИНДЕЙКА');

insert into product(id, name, type_id, expired_date, price)
values (1, 'Российский сыр', 1, '2021-04-25', 150)
;
insert into product(id, name, type_id, expired_date, price)
values (2, 'Французский сыр', 1, '2021-04-24', 250)
;
insert into product(id, name, type_id, expired_date, price)
values (3, 'Твердый в нарезку', 1, '2021-04-23', 120)
;
insert into product(id, name, type_id, expired_date, price)
values (4, 'Тертый сыр', 1, '2021-04-20', 160)
;
insert into product(id, name, type_id, expired_date, price)
values (5, 'Шоколадное мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (6, 'Фисташковое мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (7, 'Клубничное мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (8, 'Малиновое мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (9, 'Смородиновое мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (10, 'Пломбир мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (11, 'Крем-брюле мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (12, 'Арбузное мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (13, 'Рожок мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (14, 'Из грецкого ореха мороженое', 3, '2021-04-30', 100)
;
insert into product(id, name, type_id, expired_date, price)
values (15, 'Домик в деревне 3.2%', 2, '2021-04-30', 200)
;
insert into product(id, name, type_id, expired_date, price)
values (16, 'Филе индейки', 4, '2021-04-30', 500)
;
insert into product(id, name, type_id, expired_date, price)
values (17, 'Грудка индейки', 2, '2021-04-30', 250)
;
--все продукты с типом сыр
select * from product p 
join type t on t.id=p.type_id
where t.name = 'СЫР';
--все продукты, у которых в названии есть слово мороженное
select * from product p 
where p.name like '%мороженое%';
--все продукты, срок годности которых заканчивается в следующем месяце
select * from product p
where date_part('month', p.expired_date) = date_part('month', now() + interval '1 month');
--запрос, который выводит самый дорогой продукт
select * from product
where price = (select max(price) from product);
--запрос, который выводит для каждого типа количество продуктов к нему принадлежащих
select t.name as имя_типа, count(p.type_id) as количество
from type t
join product p
on t.id = p.type_id
group by t.name
having count(p.type_id) > 0;
--запрос на получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product p
join type t
on t.id = p.type_id
where t.name = 'СЫР' or t.name = 'МОЛОКО';
--запрос, который выводит тип продуктов, которых осталось меньше 10 шт.
select t.name, count(t.name) from type t
join product p on p.type_id = t.id
group by t.name
having count(t.name) < 10;
--вывести все продукты и их тип
select t.name, p.name from product p
join type t
on t.id = p.type_id;




