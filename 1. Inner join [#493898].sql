create table nomer(
id serial primary key,
	name varchar(255),
	auto_id int references auto(id)
);

insert into auto(marka, model, price) values  ('bmw', '3', 35000);
insert into auto(marka, model, price) values  ('audi', '4', 45000);
insert into auto(marka, model, price) values  ('mercedes', 'c', 55000);
insert into nomer(name, auto_id) values ('12313123', 2);
insert into nomer(name, auto_id) values ('342413123', 3);
insert into nomer(name, auto_id) values ('234243', 4);

select a.marka, a.model, a.price, n.id as №, n.name as Гос_номер
from auto a join nomer n on n.auto_id = a.id;

select * from auto a join nomer n on n.auto_id = a.id;

select a.marka as Марка_авто, a.model as Модель_авто, a.price as Цена_за_авто, n.id as №, n.name as Гос_номер
from auto a join nomer n on n.auto_id = a.id;
