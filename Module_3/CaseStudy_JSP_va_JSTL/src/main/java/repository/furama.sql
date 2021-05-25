drop database if exists furama_test;

create database furama_test;

use furama_test;


drop table if exists khach_hang;
drop table if exists loai_khach_hang;
create table loai_khach_hang(
	id_loai_khach_hang int primary key,
    loai_khach_hang varchar(45) not null unique
);

create table khach_hang(
	id_khach_hang int primary key auto_increment,
    id_loai_khach_hang int not null,
    ho_ten varchar(45) not null,
    ngay_sinh date not null,
    CMND varchar(45) not null unique,
    so_dien_thoai varchar(45) not null,
    email varchar(45) unique,
    dia_chi varchar(45) not null,
    foreign key(id_loai_khach_hang) references loai_khach_hang(id_loai_khach_hang)
);

insert into loai_khach_hang
	value (1, 'Diamond'), (2, 'Platinium'), (3, 'Gold'), (4, 'Silver'), (5, 'Member');
    
insert into khach_hang(id_loai_khach_hang, ho_ten, ngay_sinh, CMND, so_dien_thoai, email, dia_chi) value
-- id_khach_hang, id_loai_khach_hang, ho_ten, ngay_sinh, CMND, so_dien_thoai, email, dia_chi
	(1,'Nguyễn Trần Bình', '2000/09/12', '206380833', '0934472768', 'tranbinh@gmail.com', 'Nghi Phú, Tp.Vinh, Nghệ An'),
    (1,'Nguyễn Văn Cảnh', '2000/07/02', '212388706', '0903586881', 'vancanh@gmail.com', 'Bình Đông, Bình Sơn, Quảng Ngãi'),
    (2,'Bùi Văn Châu', '2000/07/26', '197404649', '0967341010', 'vanchau@gmail.com', 'Triệu Hoá, Triệu Phong, Quảng Trị'),
    (3,'Đỗ Minh Châu', '2000/04/15', '212860203', '0913117965', 'minhchau@gmail.com', 'Bình Nguyên, Bình Sơn, Quảng Ngãi'),
    (3,'Lưu Thị Tâm Châu', '2000/04/30', '201818758', '0798429841', 'tamchau@gmail.com', 'Thanh Khê Tây, Thanh Khê, Đà Nẵng'),
    (2,'Châu Ngọc Chi', '2000/08/26', '2062288046', '0819634807', 'ngocchi@gmail.com', 'Tâm Xuân Li, Núi Thành, Quảng Nam'),
    (4,'Đặng Minh Chiến', '2000/06/26', '201796640', '0913464257', 'minhchien@gmail.com', 'An Khê, Thanh Khê, Đà Nẵng'),
    (4,'Đặng Quang Chiến', '2000/06/03', '194628460', '0965371515', 'quangchien@gmail.com', 'Đức Ninh, Đồng Hới, Quảng Bình'),
    (5,'Võ Đức Chiến', '2000/01/18', '198451692', '0989506515', 'ducchien@gmail.com', 'Hải Thái, Gio Linh, Quảng Trị'),
    (5,'Võ Đức Chiến', '2000/01/18', '198451693', '0989506515', 'ducchien1@gmail.com', 'Hải Thái, Gio Linh, Quảng Trị'),
    (5,'Bùi Hữu Nhật Chinh', '2000/08/14', '206152106', '0396802226', 'nhatchinh@gmail.com', 'Tư, Đông Giang, Quảng Nam');
    
drop procedure if exists find_customer_by_id;
DELIMITER $$
create procedure find_customer_by_id(IN customer_id int)
begin
	select * from khach_hang where id_khach_hang = customer_id;
end $$
DELIMITER ;
call find_customer_by_id(1);

drop procedure if exists edit_customer;
DELIMITER $$
create procedure edit_customer(IN customer_id int, IN customer_id_loai_khach_hang int, IN customer_ho_ten varchar(45), 
	IN customer_ngay_sinh date, IN customer_CMND varchar(45), IN customer_so_dien_thoai varchar(45), IN customer_email varchar(45), 
    IN customer_dia_chi varchar(45))
begin
	update khach_hang
    set id_loai_khach_hang = customer_id_loai_khach_hang, ho_ten = customer_ho_ten, ngay_sinh = customer_ngay_sinh, CMND = customer_CMND,
		so_dien_thoai = customer_so_dien_thoai, email = customer_email, dia_chi = customer_dia_chi
    where id_khach_hang = customer_id;
end $$
DELIMITER ;
call edit_customer(1, 2,'Nguyễn Trần Bình', '2000/09/12', '206380833', '0934472768', 'tranbinh@gmail.com', 'Nghi Phú, Tp.Vinh, Nghệ An');

drop procedure if exists new_customer;
DELIMITER $$
create procedure new_customer(IN customer_id_loai_khach_hang int, IN customer_ho_ten varchar(45), 
	IN customer_ngay_sinh date, IN customer_CMND varchar(45), IN customer_so_dien_thoai varchar(45), IN customer_email varchar(45), 
    IN customer_dia_chi varchar(45))
begin
	insert into khach_hang(id_loai_khach_hang, ho_ten, ngay_sinh, CMND, so_dien_thoai, email, dia_chi)
    value (customer_id_loai_khach_hang, customer_ho_ten, customer_ngay_sinh, customer_CMND, customer_so_dien_thoai,
			customer_email, customer_dia_chi);
end $$
DELIMITER ;
call new_customer(2,'Nguyễn Trần Bình', '2000/09/12', '206380834', '0934472768', 'tranbinhh@gmail.com', 'Nghi Phú, Tp.Vinh, Nghệ An');

drop procedure if exists delete_customer;
DELIMITER $$
create procedure delete_customer(IN customer_id int)
begin
	delete from khach_hang where id_khach_hang = customer_id;
end $$
DELIMITER ;
call delete_customer(12);
