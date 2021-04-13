use furama_resort;

-- Yêu cầu 2
select * from nhan_vien where (ho_ten like '%H' or '%T' or '%K') or (length(ho_ten) = 15);

-- Yêu cầu 3 
select * from khach_hang;
select * from khach_hang 
	where ((round(datediff(curdate(), ngay_sinh) / 365, 0) > 18) and (round(datediff(curdate(), ngay_sinh) / 365, 0) < 50)) 
		and ((dia_chi like '%Quảng Trị') or (dia_chi like '%Đà Nẵng'));
        
-- Yêu cầu 4 
select khach_hang.ho_ten, count(hop_dong.id_khach_hang) as so_lan_dat from khach_hang 
	inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
    inner join loai_khach_hang on loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
    where loai_khach_hang.loai_khach_hang = 'Diamond'
		group by khach_hang.ho_ten
			order by so_lan_dat;   
            
-- Yêu cầu 5
select khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach_hang.loai_khach_hang, hop_dong.id_hop_dong, loai_dich_vu.ten_loai_dich_vu,
	hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,	dich_vu.chi_phi_thue + dich_vu_di_kem.don_vi*dich_vu_di_kem.gia as tong_tien from hop_dong
    right join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
    left join loai_khach_hang on loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
    left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
    left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
    left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
    left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem;

-- Yêu cầu 6
select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc from dich_vu
	inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
    inner join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
    where year(hop_dong.ngay_lam_hop_dong) <=2018 or (year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) >3) or year(hop_dong.ngay_lam_hop_dong) >=2020;
    
-- Yêu cầu 7
select hop_dong.id_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc from dich_vu
	inner join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
    inner join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
    inner join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
    where (year(hop_dong.ngay_lam_hop_dong) = 2018) and (year(hop_dong.ngay_lam_hop_dong) != 2019);
    
-- Yêu cầu 8
-- Cách 1
select ho_ten from khach_hang 
union 
select ho_ten from khach_hang ;
-- Cách 2
select distinct ho_ten from khach_hang;
-- Cách 3
select ho_ten from khach_hang group by ho_ten;

-- Yêu cầu 9
select month(ngay_lam_hop_dong) as 'Tháng', count(month(ngay_lam_hop_dong)) as 'Số khách hàng đặt phòng' from hop_dong 
	group by ngay_lam_hop_dong having year(ngay_lam_hop_dong) = 2019;

-- Yêu cầu 10
select hop_dong.id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, count(hop_dong_chi_tiet.id_hop_dong) as so_luong_dich_vu_di_kem from hop_dong
	inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
    group by hop_dong_chi_tiet.id_hop_dong;
    
-- Yêu cầu 11
select khach_hang.ho_ten, dich_vu_di_kem.ten_dich_vu_di_kem, loai_khach_hang.loai_khach_hang from khach_hang
	inner join hop_dong  on hop_dong.id_khach_hang = khach_hang.id_khach_hang
    inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
    inner join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
    inner join loai_khach_hang on loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
    where (loai_khach_hang.loai_khach_hang = 'Diamond') and ((khach_hang.dia_chi like '%Vinh%') or (khach_hang.dia_chi like '%Quảng Ngãi%'));
    
-- Yêu cầu 12
select hop_dong.id_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu, 
	count(hop_dong_chi_tiet.id_hop_dong) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc from hop_dong
		inner join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
        inner join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
        inner join dich_vu on dich_vu.id_dich_vu = hop_dong.id_hop_dong
        left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        where (year(hop_dong.ngay_lam_hop_dong) = 2019) and (month(hop_dong.ngay_lam_hop_dong) >= 10)
        group by hop_dong_chi_tiet.id_hop_dong;
        
-- Yêu cầu 13
select dich_vu_di_kem.id_dich_vu_di_kem, ten_dich_vu_di_kem from dich_vu_di_kem
	inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    inner join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
    group by dich_vu_di_kem.id_dich_vu_di_kem
    order by count(dich_vu_di_kem.id_dich_vu_di_kem) desc limit 1;
    
-- Yêu cầu 14
select hop_dong.id_hop_dong, dich_vu.ten_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_lan_su_dung from hop_dong
	inner join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
    inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	inner join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
    group by dich_vu_di_kem.id_dich_vu_di_kem having so_lan_su_dung = 1;
    
-- Yêu cầu 15
select nhan_vien.id_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi, count(hop_dong.id_nhan_vien) as so_lan from nhan_vien
	inner join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do
    inner join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan
    inner join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
    where (year(hop_dong.ngay_lam_hop_dong) >= 2018) and (year(hop_dong.ngay_lam_hop_dong) >= 2019)
    group by nhan_vien.id_nhan_vien having so_lan = 1;
    
-- Yêu cầu 16
    delete from nhan_vien
        where nhan_vien.id_nhan_vien not in (
			select * from (select nhan_vien.id_nhan_vien from  nhan_vien
				inner join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
            ) as x
        );
        
-- Yêu cầu 17
select khach_hang.ho_ten, loai_khach_hang.loai_khach_hang, hop_dong.ngay_lam_hop_dong, hop_dong.tong_tien from khach_hang
	inner join loai_khach_hang on loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
    inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
    where (loai_khach_hang.loai_khach_hang = 'Diamond') and (year(hop_dong.ngay_lam_hop_dong) = 2019) and (hop_dong.tong_tien > 10000000);
    
update khach_hang
	inner join loai_khach_hang on loai_khach_hang.id_loai_khach_hang = khach_hang.id_loai_khach_hang
    inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
    set khach_hang.id_loai_khach_hang = 1
    where (loai_khach_hang.loai_khach_hang = 'Platinium') and (year(hop_dong.ngay_lam_hop_dong) = 2019) and (hop_dong.tong_tien > 10000000);
    
-- Yêu cầu 18
select khach_hang.id_khach_hang, khach_hang.ho_ten from khach_hang
	inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
	inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	where year(hop_dong.ngay_lam_hop_dong) <= 2019 and (khach_hang.id_khach_hang = hop_dong.id_khach_hang);

delete khach_hang, hop_dong, hop_dong_chi_tiet from khach_hang
	inner join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
	inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
	where year(hop_dong.ngay_lam_hop_dong) <= 2016 and (khach_hang.id_khach_hang = hop_dong.id_khach_hang);
    
-- Yêu cầu 19
select dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, count(hop_dong_chi_tiet.id_dich_vu_di_kem) from dich_vu_di_kem
	inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    where dich_vu_di_kem.id_dich_vu_di_kem in (
		select dich_vu_di_kem.id_dich_vu_di_kem from dich_vu_di_kem
			inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
            group by dich_vu_di_kem.ten_dich_vu_di_kem having count(hop_dong_chi_tiet.id_dich_vu_di_kem) >=3
        );
    
update dich_vu_di_kem
	-- inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    set dich_vu_di_kem.gia = dich_vu_di_kem.gia *2 
    where dich_vu_di_kem.id_dich_vu_di_kem in (
		select * from (
			select dich_vu_di_kem.id_dich_vu_di_kem from dich_vu_di_kem
            inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
            inner join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
            where year(hop_dong.ngay_lam_hop_dong) = 2019) as x
            group by id_dich_vu_di_kem having count(id_dich_vu_di_kem) >= 3
	);
    
-- Yêu cầu 20 
select id_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, 'Nhân viên' as 'Phân loại' from nhan_vien
union all
select id_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, 'Khách hàng' from khach_hang;

-- Yêu cầu 21
create view V_NHANVIEN as select nhan_vien.id_nhan_vien, ho_ten, vi_tri.ten_vi_tri, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan,
	ngay_sinh, CMND, luong, so_dien_thoai, email, dia_chi from nhan_vien
	inner join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
    inner join vi_tri on vi_tri.id_vi_tri = nhan_vien.id_vi_tri
    inner join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do
    inner join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan
    where (nhan_vien.dia_chi like '%Hải Châu%') and (hop_dong.ngay_lam_hop_dong = '2019/12/12');
    
select * from V_NHANVIEN;

-- Yêu cầu 22
select dia_chi from V_NHANVIEN;
update nhan_vien set dia_chi = 'Liên Chiểu, Đà Nẵng' where nhan_vien in (select id_nhan_vien from V_NHANVIEN);

-- Yêu cầu 23
delimiter //
create procedure Sp_1 (in id_khach_hang int)
begin
	delete khach_hang from khach_hang
    where khach_hang.id_khach_hang = id_khach_hang;
end;
// delimiter ;

-- Yêu cầu 24
delimiter //
create procedure Sp_2 (in id_hop_dong int, id_nhan_vien int, id_khach_hang int, id_dich_vu int, ngay_lam_hop_dong date
	, ngay_ket_thuc_hop_dong date, tien_dat_coc int, tong_tien int)
begin
	insert into hop_dong value (id_hop_dong, id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc_hop_dong, tien_dat_coc, tong_tien)
    select hop_dong.id_hop_dong from hop_dong
    where id_hop_dong not in (select hop_dong.id_hop_dong from hop_dong);
end;
// delimiter ;
