create table meetings(
    id serial primary key,
    name varchar(255)
);

create table users(
    id serial primary key,
    name varchar(255)
);

create table guests(
    id serial primary key,
    guest_id int references users(id),
	meeting_id int references meetings(id),
	status varchar(255) 
);

insert into users(id, name) values (1, 'Алешенька-сынок');
insert into users(id, name) values (2, 'Иван-дурак');
insert into users(id, name) values (3, 'Алена Игоревна');

insert into meetings(id, name) values (1, 'Сборище тиктокеров');
insert into meetings(id, name) values (2, 'Серьезное совещание');
insert into meetings(id, name) values (3, 'Обед');

insert into guests(id, guest_id, meeting_id, status)
values (1, 1, 1, 'Не принял');
insert into guests(id, guest_id, meeting_id, status)
values (2, 2, 1, 'Не принял');
insert into guests(id, guest_id, meeting_id, status)
values (3, 3, 1, 'Не принял');

insert into guests(id, guest_id, meeting_id, status)
values (4, 1, 2, 'Принял');
insert into guests(id, guest_id, meeting_id, status)
values (5, 2, 2, 'Принял');
insert into guests(id, guest_id, meeting_id, status)
values (6, 3, 2, 'Не принял');

insert into guests(id, guest_id, meeting_id, status)
values (7, 1, 3, 'Принял');
insert into guests(id, guest_id, meeting_id, status)
values (8, 2, 3, 'Принял');
insert into guests(id, guest_id, meeting_id, status)
values (9, 3, 3, 'Принял');

select * from guests;
select * from meetings;
select * from users;

select m.name as Название_мероприятия, count(g.id) as Кол_во_участников
from meetings m
join guests g on m.id = g.meeting_id
group by m.name
having count(g.id) = (select count(g.id) as y from company g 
					  join person q on g.id = q.company_id group by g.name) as d);

select count(g.id) as m from guests g 
					  join meetings q on g.meeting_id = q.id 
					  where g.status != 'Принял'
					  group by q.name
					 ;
--Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.					 
select m.name as Название_мероприятия, count(g.id) as Кол_во_участников
from meetings m
left join guests g on m.id = g.meeting_id
and g.status = 'Принял'
group by m.name;

--Нужно получить все совещания, где не было ни одной заявки на посещения
select m.name as Название_мероприятия
from meetings m
left join guests g on m.id = g.meeting_id
and g.status = 'Принял'
group by m.name
having count(g.id) = 0;