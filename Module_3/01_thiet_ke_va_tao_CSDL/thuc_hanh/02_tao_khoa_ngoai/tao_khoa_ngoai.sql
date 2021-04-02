drop database if exists tao_khoa_ngoai;

create database tao_khoa_ngoai;

use tao_khoa_ngoai;

create table customers(
	id int auto_increment,
    `name` varchar(40),
    address varchar(255),
	email varchar(255),
    primary key(id)
);

create table orders(
	id int auto_increment primary key,
    staff varchar(50),
    customer_id int,
    foreign key(customer_id) references customers(id)
);

