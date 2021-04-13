insert into role(name) values ('admin');
insert into role(name) values ('user');

insert into users(name, role_id) values ('Akop', 1);
insert into users(name, role_id) values ('Viktor', 2);
insert into users(name, role_id) values ('Zeliboba', 2);

insert into rules(name) values ('edit');
insert into rules(name) values ('read');

insert into role_rules(role_id, rules_id) values (1, 1);
insert into role_rules(role_id, rules_id) values (2, 2);

insert into category(name) values ('update');
insert into category(name) values ('install');

insert into state(name) values ('done');
insert into state(name) values ('in work');

insert into item(name, users_id, category_id, state_id) values ('task21231', 1, 1, 1);
insert into item(name, users_id, category_id, state_id) values ('task24234234', 2, 2, 2);
insert into item(name, users_id, category_id, state_id) values ('task10', 3, 2, 2);

insert into comments(name, item_id) values ('comment1', 1);
insert into comments(name, item_id) values ('comment2', 2);
insert into comments(name, role_id) values ('comment3', 3);

insert into attachs(name, item_id) values ('attachs1', 1);
insert into attachs(name, item_id) values ('attachs2', 2);
insert into attachs(name, item_id) values ('attachs3', 3);
