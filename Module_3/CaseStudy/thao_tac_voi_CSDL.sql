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

    
    
    
    
    
    
    
    
