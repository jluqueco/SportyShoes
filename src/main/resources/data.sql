insert into categories (description, date_added) values('Cycling', curdate());
insert into categories (description, date_added) values('Baseball', curdate());
insert into categories (description, date_added) values('Soccer', curdate());

insert into products (date_added, name, price, category_categoryid) values(curdate(), 'Cool Cycling Shoes', 100.02, 1);
insert into products (date_added, name, price, category_categoryid) values(curdate(), 'Jordan', 450.99, 2);

insert into users (admin, birth_date, last_name, name, username, password) values (1,'1983-09-01' , 'Luque', 'Javier', 'jluqueco', '123')


