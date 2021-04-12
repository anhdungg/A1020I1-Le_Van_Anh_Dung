drop database if exists cac_thong_dung_trong_SQL;

create database cac_thong_dung_trong_SQL;

use cac_thong_dung_trong_SQL;

create table hoc_vien(
	id int,
    ten varchar(30),
    tuoi int,
    khoa_hoc varchar(30),
    so_tien int
);

insert into hoc_vien value
	(1, 'Hoang', 21, 'CNTT', 400000),
    (2, 'Viet', 19, 'DTVT', 320000),
    (3, 'Thanh', 18, 'KTDN', 400000),
    (4, 'Nhan', 19, 'CK', 450000),
    (5, 'Huong', 20, 'TCNH', 500000),
    (5, 'Huong', 20, 'TCNH', 200000);
    
-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
select * from hoc_vien where ten = 'Huong';

-- Viết câu lệnh lấy ra tổng số tiền của Huong
select 'Huong' as 'Ten', sum(so_tien) as 'Tong tien' from hoc_vien where ten = 'Huong';

-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
select * from hoc_vien group by hoc_vien.id having count(id) = 1;

select * from hoc_vien where id in (select id from hoc_vien group by id having count(id) = 1);

select * from hoc_vien hvv where not exists ( select 1 from hoc_vien hv where hv.id = hvv.id limit 1, 1)