drop database if exists manage_student;

create database manage_student;

use manage_student;

create table student(
	id int primary key auto_increment,
    `name` varchar(30),
    day_of_birth date
);

insert into student
values(1, 'Dũng', '1997-11-05');

insert into student(`name`, day_of_birth)
values
('Son', '1998-07-20'),
('Dat', '1998-02-11'),
('Kien', '1998-10-03');

select `name`
from student
where id = 1;

alter table student
add column email varchar(30);


update student set `name` = 'Dung' where `name` = 'Dũng';
update student set email = 'Son@gmail.com' where `name` = 'Son';
update student set email = 'Dat@gmail.com' where `name` = 'Dat';
update student set email = 'Kien@gmail.com' where `name` = 'Kien';
update student set email = 'Dung@gmail.com' where `name` = 'Dung';

delete from student
where `name` = 'Dung';


