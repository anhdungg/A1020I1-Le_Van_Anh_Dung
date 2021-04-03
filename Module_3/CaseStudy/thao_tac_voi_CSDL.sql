use furama_resort;

-- Yêu cầu 2
select * from nhan_vien where (ho_ten like '%H' or '%T' or '%K') or (length(ho_ten) = 15);

-- Yêu cầu 3 
select * from khach_hang;
select * from khach_hang 
	where ((round(datediff(curdate(), ngay_sinh) / 365, 0) > 18) and (round(datediff(curdate(), ngay_sinh) / 365, 0) < 50)) 
		and ((dia_chi like '%Quảng Trị') or (dia_chi like '%Đà Nẵng'));
        
-- Yêu cầu 4 
select count(id_khach_hang), ho_ten from hop_dong, khach_hang
    
    
    
    
    
    
    
