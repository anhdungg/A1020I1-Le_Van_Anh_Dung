drop database if exists demoo;

create database demoo;

use demoo;

create table products(
	id int,
    product_code varchar(30),
    product_name varchar(50),
    product_price int,
    product_amount int,
    product_description text,
    product_status varchar(10)
);

insert into products value
(1, '111', 'cxrr', 11, 111, 'sadafas', 'available'),
(2, '222', 'ytj', 22, 222, 'sdasv', 'available'),
(3, '333', 'fdvv', 33, 333, 'agrhwth', 'available'),
(4, '444', 'hrhjy', 44, 444, 'erq3fsd', 'available'),
(5, '555', 'afsdf', 55, 555, 'trhetr', 'available'),
(6, '666', 'asd', 66, 666, 'wtww', 'available'),
(7, '777', 'qwe', 77, 777, 'yjtj', 'available');

create index id_product_id on products (id);

create index id_product_name_price on products (product_name, product_price);

explain select * from products where id = 4;

create view v_product as select product_code, product_name, product_price, product_status from products;

update v_product set product_code = '888' where product_code = '111';

delete v_product from v_product where product_code = '888';

delimiter //
create procedure sp_read_product ()
begin
	select * from products;
end;
// delimiter ;

call sp_read_product();

delimiter //
create procedure sp_add_product (in id int, product_code varchar(30), product_name varchar(50), product_price int, product_amount int
	, product_description text, product_status varchar(10))
begin
	insert into products value (id, product_code, product_name, product_price, product_amount, product_description, product_status);
end;
// delimiter ;

call sp_add_product(1, '111', 'cxrr', 11, 111, 'sadafas', 'available');

delimiter //
create procedure sp_edit_product (in id int, product_description text)
begin
	update products set products.product_description = product_description where products.id = id;
end;
// delimiter ;

call sp_edit_product(1, 'Edit');

delimiter //
create procedure sp_delete_product (in id int)
begin
	delete products from products where products.id = id;
end;
// delimiter ;

call sp_delete_product(9);