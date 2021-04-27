create table kuzov(
    id serial primary key,
    name varchar(255)
);

create table dvigatel(
    id serial primary key,
    name varchar(255)
);

create table korobkaperedach(
    id serial primary key,
    name varchar(255)
);

create table car(
	name varchar(255),
    kuzov_id int references kuzov(id),
    dvigatel_id int references dvigatel(id),
    korobkaperedach_id int references korobkaperedach(id)
);

insert into kuzov(name) values ('Седан');
insert into kuzov(name) values ('Кабриолет');
insert into kuzov(name) values ('Кроссовер');
insert into kuzov(name) values ('Универсал');

insert into dvigatel(name) values ('1.6');
insert into dvigatel(name) values ('2.0');
insert into dvigatel(name) values ('3.0');
insert into dvigatel(name) values ('5.0');

insert into korobkaperedach(name) values ('automat');
insert into korobkaperedach(name) values ('dsg');
insert into korobkaperedach(name) values ('mech');
insert into korobkaperedach(name) values ('variator');

select * from kuzov;
select * from dvigatel;
select * from korobkaperedach;
select * from car;

insert into car(name, kuzov_id, dvigatel_id, korobkaperedach_id)
values ('Reno Logan', 1, 1, 3);
insert into car(name, kuzov_id, dvigatel_id, korobkaperedach_id)
values ('BMW 3', 1, 2, 1);
insert into car(name, kuzov_id, dvigatel_id, korobkaperedach_id)
values ('AUDI TT', 2, 2, 2);

--Вывести список всех машин и все привязанные к ним детали
select c.name as Наименование_авто, k.name as Тип_кузова,
d.name as Объем_двигателя, kb.name as Тип_коробки_передач
from car c 
left join kuzov k on c.kuzov_id = k.id
left join dvigatel d on c.dvigatel_id = d.id
left join korobkaperedach kb on c.korobkaperedach_id = kb.id;

-- Вывести отдельно детали
-- кузов
select * from kuzov k 
left join car c on k.id = c.kuzov_id
where c.name is null;

-- двигатель
select * from dvigatel d 
left join car c on d.id = c.dvigatel_id
where c.name is null;

-- коробка передач
select * from korobkaperedach kb
left join car c on kb.id = c.korobkaperedach_id
where c.name is null;
