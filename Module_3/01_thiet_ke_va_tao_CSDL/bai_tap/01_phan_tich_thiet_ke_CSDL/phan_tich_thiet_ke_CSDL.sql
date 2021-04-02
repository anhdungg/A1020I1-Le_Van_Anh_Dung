drop database if exists phan_tich_va_thiet_ke_CSDL;

create database phan_tich_va_thiet_ke_CSDL;

use phan_tich_va_thiet_ke_CSDL;

create table productlines(
	productline varchar(50) primary key,
    text_descriptions text,
    image char
);

create table offices(
	office_code varchar(10) primary key,
    city varchar(50) not null,
    phone varchar(50) not null,
    address_line_1 varchar(50) not null,
    address_line_2 varchar(50),
    state varchar(50),
    country varchar(50) not null, 
    postal_code varchar(15) not null
);

create table employees(
	employee_number int primary key,
    last_name varchar(50) not null,
    first_name varchar(50) not null,
    email varchar(100) not null,
	job_title varchar(50) not null,
    manage int,
    office_code varchar(10),
    -- foreign key(employee_number) references employees(manage),
    foreign key(office_code) references offices(office_code)
);

create table customers(
	customer_number int primary key,
    customer_name varchar(50) not null,
    contact_last_name varchar(50) not null,
    contact_first_name varchar(50) not null,
    phone_number varchar(50) not null,
    address_line1 varchar(50) not null,
    address_line2 varchar(50),
    city varchar(50)not null,
    state varchar(50)not null,
    postal_code varchar(15)not null,
    country varchar(50)not null,
    credit_limit float,
    employee_number int,
    foreign key(employee_number) references employees(employee_number)
);

create table products(
	product_code varchar(15) primary key,
    product_name varchar(70) not null,
    product_scale varchar(10) not null,
    product_vendor varchar(50) not null,
    product_description text not null,
    quanity_in_stock int not null,
    buy_price float not null,
    MSRP float not null,
    productline varchar(50),
    foreign key(productline) references productlines(productline)
);

create table orders(
	order_number int primary key,
    order_date date not null,
    required_date date not null,
    shipped_date date,
    `status` varchar(15) not null,
    `comment` text,
    quantity_ordered int not null,
    price_each float not null,
    customer_number int,
    foreign key(customer_number) references customers(customer_number)
);

create table payments(
	check_number varchar(50) primary key,
    payment_date date not null,
    amount float not null,
    customer_number int,
    foreign key(customer_number) references customers(customer_number)
);

create table product_order(
	product_code varchar(15),
    order_number int,
    primary key(product_code, order_number),
    foreign key(product_code) references products(product_code),
    foreign key(order_number) references orders(order_number)
);