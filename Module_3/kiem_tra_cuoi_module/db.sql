drop database if exists t_complex;

create database t_complex;

use t_complex;

create table trang_thai(
	id_trang_thai int primary key,
    ten_trang_thai varchar(50) not null
);

create table loai_van_phong(
	id_loai_van_phong int primary key,
    ten_loai_van_phong varchar(50) not null
);

create table mat_bang(
	id varchar(50) primary key,
    id_trang_thai int not null,
    dien_tich double not null,
    tang int not null, 
    id_loai_van_phong int not null,
    gia_tien double not null,
    ngay_bat_dau date not null,
    ngay_ket_thuc date not null,
    foreign key(id_loai_van_phong) references loai_van_phong(id_loai_van_phong),
    foreign key(id_trang_thai) references trang_thai(id_trang_thai)
);

insert into trang_thai value 
(1, 'Trống'),
(2, 'Hạ Tầng'),
(3, 'Đầy đủ');

insert into loai_van_phong value 
(1, 'Văn phòng chia sẻ'),
(2, 'Văn phòng trọn gói');

insert into mat_bang value 
('111-11-11', 1, 100, 2, 1, 5000000, '2021/02/10', '2021/03/10'),
('222-22-22', 2, 200, 3, 2, 5000000, '2021/02/10', '2021/03/10');