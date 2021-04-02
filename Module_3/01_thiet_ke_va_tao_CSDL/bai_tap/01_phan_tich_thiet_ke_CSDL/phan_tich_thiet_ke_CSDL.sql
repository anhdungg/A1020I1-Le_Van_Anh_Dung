drop database if exists phan_tich_va_thiet_ke_CSDL;

create database phan_tich_va_thiet_ke_CSDL;

use phan_tich_va_thiet_ke_CSDL;

create table customers(
	id int auto_increment primary key,
    `name` varchar(40),
    phone_number int(11),
    address varchar(255)
);

create table products_line(
	id int,
    descriptions varchar(255)
);

create table products(
	id int primary key,
    `name` varchar(40),
    supplier varchar(40),
    number_stock int,
    price_entered int,
    price int
);

create table orders(
	order_number int,
    date_of_purchase date,
    delivery_date date,
    actual_delivery_date date,
    number_of_order int,
    price int
);

-- create table 