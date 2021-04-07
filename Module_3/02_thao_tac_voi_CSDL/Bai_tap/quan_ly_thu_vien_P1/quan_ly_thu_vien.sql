drop database if exists quan_ly_thu_vien;

create database quan_ly_thu_vien;

use quan_ly_thu_vien;

create table phan_loai_sach(
	ma_loai_sach int primary key,
    loai_sach varchar(40)
);

create table sach(
	ma_sach int primary key,
    ma_loai_sach int,
    ten_sach varchar(50),
    nha_san_xuat varchar(50),
    tac_gia varchar(40),
    nam_xuat_ban date,
    so_lan_xuat_ban int, 
    gia float,
    anh varchar(30),
    foreign key(ma_loai_sach) references phan_loai_sach(ma_loai_sach)
);

create table hoc_sinh(
	ma_hoc_sinh int primary key,
    ten_hoc_sinh varchar(50),
    ngay_sinh date,
    dia_chi varchar(255),
    email varchar(50),
    so_dien_thoai varchar(20),
    anh varchar(30)
);

create table phieu_muon(
	ma_hoc_sinh int,
    ma_sach int,
    ngay_muon date,
    ngay_tra date,
    primary key(ma_hoc_sinh, ma_sach),
    foreign key(ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh),
    foreign key(ma_sach) references sach(ma_sach)
);

insert into phan_loai_sach value
	(1, 'Sách nhi đồng'),
    (2, 'Sách chính trị'),
    (3, 'Sách văn học'),
    (4, 'Sách tham khảo'),
    (5, 'Sách khoa hoc');
    
insert into sach value
	(1, 1, 'Thần đồng đất việt', 'Kim đồng', 'Phan Thị', '2001/01/01', 4, 15000.0, 'Image'),
    (2, 2, 'Chính trị luân', 'Thế giới', 'Alpha Books', '2018/11/14', 1, 131820.0, 'Image'),
    (3, 3, 'Tôi thấy hoa vàng trên cỏ xanh', 'Nhà xuất bản Trẻ', 'Nguyễn Nhật Ánh', '2017/08/11', 1, 50000.0, 'Image'),
    (4, 4, 'Tuyển chọn đề thi vào lớp 10 môn toán', 'Đại học quốc gia Hà Nội', 'Trần Xuân Tiếp', '2021/03/03', 1, 55000.0, 'Image'),
    (5, 5, 'Ngân hà và những thiên hà khác', 'Dân Trí', 'Nguyễn Ngoan', '2000/07/30', 2, 10000.0, 'Image');
    
insert into hoc_sinh value
	(1, 'Trần Thị Phương Anh', '1998/01/30', 'Triệu Tài, Triệu Phong, Quảng Trị', 'phuonganh@gmail.com', '0934472768', 'Image'),
    (2, 'Phạm Văn Hoàng Ân', '2000/07/15', 'Hải Châu II, Hải Châu, Đà Nẵng', 'hoangan@gmail.com', '0903586881', 'Image'),
    (3, 'Lê Đăng Tú Anh', '1999/12/20', 'An Khê, Thanh Khê, Đà Nẵng', 'phuonganh@gmail.com', '0967341010', 'Image'),
    (4, 'Mai Văn Kì Anh', '2000/06/22', 'Hải Ba, Hải Lăng, Quảng Trị', 'phuonganh@gmail.com', '0913117965', 'Image'),
    (5, 'Nguyễn Xuân Bắc', '2000/07/20', 'Mân Thái, Sơn Trà, Đà Nẵng', 'phuonganh@gmail.com', '0798429841', 'Image');
    
insert into phieu_muon value
	(1, 1, '2021/01/01', null),
    (2, 2, '2021/02/01', '2021/02/02'),
    (3, 3, '2021/01/15', '2021/03/01'),
    (4, 4, '2021/03/21', null),
    (5, 5, '2020/12/29', '2021/02/02');
    

select hoc_sinh.ten_hoc_sinh, sach.ten_sach from phieu_muon
	inner join hoc_sinh on hoc_sinh.ma_hoc_sinh = phieu_muon.ma_hoc_sinh 
    inner join sach on sach.ma_sach = phieu_muon.ma_sach;
    
select phan_loai_sach.loai_sach from phan_loai_sach
	inner join sach on sach.ma_loai_sach = phan_loai_sach.ma_loai_sach;
    