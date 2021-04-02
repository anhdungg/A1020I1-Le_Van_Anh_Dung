drop database if exists xac_dinh_khoa_chinh_va_khoa_ngoai;

create database xac_dinh_khoa_chinh_va_khoa_ngoai;

use xac_dinh_khoa_chinh_va_khoa_ngoai;

create table accounts(
	account_number int primary key,
    account_type varchar(20),
    open_date date,
    blance int
);

create table transactions(
	tran_number int primary key,
    account_number int, 
    tran_date date,
    amouts int,
    descriptions varchar(255),
    foreign key(account_number) references accounts(account_number)
);

create table customers(
	customer_number int auto_increment primary key,
    full_name varchar(50),
    address varchar(255), 
    email varchar(50),
    phone int,
    account_number int,
    foreign key(account_number) references accounts(account_number)
);
