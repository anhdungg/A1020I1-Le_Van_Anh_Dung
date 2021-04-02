drop database if exists thao_tac_voi_bang;

create database thao_tac_voi_bang;

use thao_tac_voi_bang;

create table contacts
(
	contact_id int not null auto_increment,
    last_name varchar(30) not null,
    first_name varchar(25),
    birth_day date,
    primary key(contact_id)
);

insert into contacts values(1,'anh', 'dung', '2021/12/12'); 

create table suppliers(
	supplier_id int (11) not null auto_increment,
    supplier_name varchar(50) not null,
    account_rep varchar(30) not null default 'TBD',
    constraint supplier_pk primary key(supplier_id)
);

insert into suppliers(supplier_name, account_rep) value('abc', 'xzy');

drop table contacts, suppliers;

-- Thêm cột
alter table contacts
	add last_name varchar(50) not null;
    
-- Thay đổi kiểu dữ liệu của cột
alter table contacts
	modify last_name varchar(40) not null;
    
-- Xoá cột
alter table contacts
	drop column last_name;

-- Thay đổi tên cột
alter table contacts
	change column birth_day day_of_birth date ;
    
-- Thay đổi tên bảng
alter table contacts
	rename to people;
    
    
