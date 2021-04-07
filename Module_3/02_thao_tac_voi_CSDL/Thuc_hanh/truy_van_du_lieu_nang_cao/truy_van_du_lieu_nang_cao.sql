drop database if exists truy_van_du_lieu_nang_cao;

create database truy_van_du_lieu_nang_cao;

use truy_van_du_lieu_nang_cao;

create table productlines(
	product_line varchar(30) primary key,
    text_description text,
    html_description varchar(50),
    image varchar(50)
);

create table products(
	product_code int primary key,
    product_name varchar(50),
    product_line varchar(30),
    product_scale int,
    product_vendor varchar(50),
    product_description text,
    quantity_in_stock int,
    buy_price float,
    MSRP varchar(40),
    foreign key(product_line) references productlines(product_line)
);