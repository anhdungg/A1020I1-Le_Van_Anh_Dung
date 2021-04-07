drop database if exists furama_resort;

create database furama_resort;

use furama_resort;

create table vi_tri(
	id_vi_tri int primary key,
    ten_vi_tri varchar(45) unique
);

create table trinh_do(
	id_trinh_do int primary key,
    ten_trinh_do varchar(45) unique
);

create table bo_phan(
	id_bo_phan int primary key,
    ten_bo_phan varchar(45) unique
);

create table nhan_vien(
	id_nhan_vien int primary key,
    ho_ten varchar(50) not null,
    id_vi_tri int not null,
    id_trinh_do int not null,
    id_bo_phan int not null,
    ngay_sinh date not null,
    CMND varchar(45) not null unique,
    luong varchar(45) not null,
    so_dien_thoai varchar(45) not null,
    email varchar(45) not null  unique,
    dia_chi varchar(45) not null, 
    foreign key(id_vi_tri) references vi_tri(id_vi_tri),
    foreign key(id_trinh_do) references trinh_do(id_trinh_do),
    foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);

create table loai_khach_hang(
	id_loai_khach_hang int primary key,
    loai_khach_hang varchar(45) not null unique
);

create table khach_hang(
	id_khach_hang int primary key,
    id_loai_khach_hang int not null,
    ho_ten varchar(45) not null,
    ngay_sinh date not null,
    CMND varchar(45) not null unique,
    so_dien_thoai varchar(45) not null,
    email varchar(45) unique,
    dia_chi varchar(45) not null,
    foreign key(id_loai_khach_hang) references loai_khach_hang(id_loai_khach_hang)
);

create table kieu_thue(
	id_kieu_thue int primary key,
    ten_kieu_thue varchar(45) not null unique,
    gia int not null
);

create table loai_dich_vu(
	id_loai_dich_vu int primary key,
    ten_loai_dich_vu varchar(45) not null unique
);

create table dich_vu(
	id_dich_vu int primary key,
    ten_dich_vu varchar(45) not null,
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da varchar(45),
    chi_phi_thue varchar(45),
    id_kieu_thue int not null,
    id_loai_dich_vu int not null,
    trang_thai varchar(45),
    foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue),
    foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
	id_hop_dong int primary key,
    id_nhan_vien int not null,
    id_khach_hang int not null,
    id_dich_vu int not null,
    ngay_lam_hop_dong date not null, 
    ngay_ket_thuc date not null,
    tien_dat_coc int not null,
    tong_tien int, 
    foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
    foreign key(id_khach_hang) references khach_hang(id_khach_hang),
    foreign key(id_dich_vu) references dich_vu(id_dich_vu)
);

create table dich_vu_di_kem(
	id_dich_vu_di_kem int primary key,
    ten_dich_vu_di_kem varchar(45)not null unique,
    gia int not null,
    don_vi int not null,
    trang_thai_kha_dung varchar(45)
);

create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int primary key,
    id_hop_dong int not null,
    id_dich_vu_di_kem int not null,
    so_luong int not null,
    foreign key(id_hop_dong) references hop_dong(id_hop_dong),
    foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);
