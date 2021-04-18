create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('printer', 1000);
insert into devices(name, price) values ('scaner', 5000);
insert into devices(name, price) values ('cpu', 7000);

insert into people(name) values ('masha');
insert into people(name) values ('sveta');
insert into people(name) values ('vladik');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (3, 2);

select * from devices;
select * from people;
select * from devices_people;

select avg(price) from devices; 

select p.name, avg(d.price) from devices d 
join devices_people dp on dp.device_id = d.id
join people p on p.id = dp.people_id
group by p.name;

select p.name, avg(d.price) from devices d 
join devices_people dp on dp.device_id = d.id
join people p on p.id = dp.people_id
group by p.name
having avg(d.price) > 5000



