create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name) values ('Department 1');
insert into departments(name) values ('Department 2');
insert into departments(name) values ('Department 3');

insert into employees(name, departments_id) values ('Сотрудник 1', 1);
insert into employees(name, departments_id) values ('Сотрудник 2', 2);
insert into employees(name, departments_id) values ('Сотрудник 3', 3);
insert into employees(name, departments_id) values ('Сотрудник 4', null);
insert into employees(name, departments_id) values ('Сотрудник 5', null);
insert into employees(name, departments_id) values ('Сотрудник 6', 1);

select * from departments;
select * from employees;

--запросы с left, rigth, full, cross соединениями
select * from departments d left join employees e
on d.id = e.departments_id;
select * from departments d right join employees e
on d.id = e.departments_id;
select * from departments d full join employees e
on d.id = e.departments_id;
select * from departments d cross join employees e;

--Используя left join найти департаменты, у которых нет работников
select * from departments d left join employees e 
on d.id = e.departments_id
where e.departments_id is null;

--Используя left и right join написать запросы, которые давали бы одинаковый результат 
select * from employees e left join departments d 
on e.departments_id = d.id;
select * from departments e right join employees d 
on d.departments_id = e.id;

select * from departments e left join employees d 
on d.departments_id = e.id;
select * from employees e right join departments d 
on e.departments_id = d.id;

--Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары
create table teens(
     name varchar(255),
	 gender varchar(255)
);
select * from teens;
insert into teens(name, gender) values('Иван', 'm');
insert into teens(name, gender) values('Александр', 'm');
insert into teens(name, gender) values('Ольга', 'f');
insert into teens(name, gender) values('Василий', 'm');
insert into teens(name, gender) values('Татьяна', 'f');
insert into teens(name, gender) values('Светлана', 'f');
insert into teens(name, gender) values('Виктор', 'm');
insert into teens(name, gender) values('Ирина', 'f');
select t1.name as teen1, t2.name as teen2 from teens t1 cross join teens t2
where t1.gender != t2.gender and t1.gender like 'm';