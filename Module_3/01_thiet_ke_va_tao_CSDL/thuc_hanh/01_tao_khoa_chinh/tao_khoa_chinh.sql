drop database if exists tao_khoa_chinh;

create database tao_khoa_chinh;

use tao_khoa_chinh;

create table users(
	user_id int auto_increment primary key,
    user_name varchar(40),
    `password` varchar(40),
    email varchar(40)
);

create table roles(
	role_id int auto_increment,
    role_name varchar(50),
    primary key(role_id)
);

create table user_role(
	user_id int,
    role_id int,
    primary key(user_id, role_id),
    foreign key (user_id) references users(user_id),
    foreign key (role_id) references roles(role_id)
);

-- Thêm khoá chính vào bảng
alter table users
	add primary key(user_name);
    