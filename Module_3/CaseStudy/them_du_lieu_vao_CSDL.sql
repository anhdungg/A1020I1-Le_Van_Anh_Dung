use furama_resort;

-- Yêu cầu 1
insert into vi_tri 
	value  (1, 'Lễ tân'), (2, 'Phục vụ'), (3, 'Chuyên viên'), (4, 'Giám sát'), (5, 'Quản lý'), (6, 'Giám đốc');
        
insert into trinh_do
	value (1, 'Trung cấp'), (2, 'Cao đẳng'), (3, 'Đại học'),(4, 'Sau đại học');
        
insert into bo_phan
	value (1, 'Sale-Marketing'), (2, 'Hành chính'), (3, 'Phục vụ'), (4, 'Quản lý');
    
insert into loai_khach_hang
	value (1, 'Diamond'), (2, 'Platinium'), (3, 'Gold'), (4, 'Silver'), (5, 'Member');
    
insert into kieu_thue
	value (1, 'Giờ', 500000), (2, 'Ngày', 1000000), (3, 'Tháng', 1500000), (4, 'Năm', 2000000);
    
insert into loai_dich_vu
	value (1, 'Villa'), (2, 'House'), (3, 'Room');
    
insert into dich_vu_di_kem
	value (1, 'Massage', 250000, 10, 'Còn'), (2, 'Karaoke', 200000, 20, 'Còn'), (3, 'Nước uống', 5000, 1000, 'Còn'), (4, 'Thuê xe di chuyển tham quan resort', 300000, 0, 'Hết');
    
insert into nhan_vien value
	(1, 'Trần Thị Phương Anh', 1, 1, 3, '1998/01/30', '197404273', '1000', '0969851616', 'phuonganh@gmail.com', 'Triệu Tài, Triệu Phong, Quảng Trị'),
    (2, 'Phạm Văn Hoàng Ân', 2, 2, 3, '2000/07/15', '201778392', '1100', '0969241616', 'hoangan@gmail.com', 'Hải Châu II, Hải Châu, Đà Nẵng'),
    (3, 'Lê Đăng Tú Anh', 3, 3, 2, '1999/12/20', '201775768', '100', '0912818887', 'tuanh@gmail.com', 'An Khê, Thanh Khê, Đà Nẵng'),
    (4, 'Mai Văn Kì Anh', 4, 3, 4, '2000/06/22', '197416429', '1234', '0372884712', 'kianh@gmail.com', 'Hải Ba, Hải Lăng, Quảng Trị'),
    (5, 'Nguyên Xuân Bắc', 5, 3, 4, '2000/07/20', '201835799', '9546', '0967941616', 'xuanbac@gmail.com', 'Mân Thái, Sơn Trà, Đà Nẵng'),
    (6, 'Nguyễn Quốc Bản', 5, 4, 1, '2000/04/27', '233280732', '50', '0966681313', 'quocban@gmail.com', 'Plei Cần, Ngọc Hồi, Kon Tum'),
    (7, 'Hồ Ngọc Bảo', 1, 2, 3, '1998/06/03', '201748660', '755', '0913394495', 'ngocbao@gmail.com', 'Hoà Minh, Liên Chiểu, Đà Nẵng'),
    (8, 'Trần Phước Gia Bảo', 3, 2, 2, '2000/06/17', '201786230', '2000', '0945313999', 'giabao@gmail.com', 'Khuê Trung, Cẩm Lệ, Đà Nẵng'),
    (9, 'Nguyễn Ngọc Bin', 2, 2, 3, '2000/03/12', '192135920', '600', '0907736736', 'ngocbin@gmail.com', 'Lộc Trì, Phú Lộc, Thừa Thiên Huế'),
    (10, 'Lê Đức Bình', 3, 4, 1, '1999/02/15', '197377672', '750', '0982414127', 'ducbinh@gmail.com', 'Triệu Đô, Triệu Phong, Quảng Trị');
    
insert into khach_hang value
-- id_khach_hang, id_loai_khach_hang, ho_ten, ngay_sinh, CMND, so_dien_thoai, email, dia_chi
	(1, 1,'Nguyễn Trần Bình', '2000/09/12', '206380833', '0934472768', 'tranbinh@gmail.com', 'Nghi Phú, Tp.Vinh, Nghệ An'),
    (2, 1,'Nguyễn Văn Cảnh', '2000/07/02', '212388706', '0903586881', 'vancanh@gmail.com', 'Bình Đông, Bình Sơn, Quảng Ngãi'),
    (3, 2,'Bùi Văn Châu', '2000/07/26', '197404649', '0967341010', 'vanchau@gmail.com', 'Triệu Hoá, Triệu Phong, Quảng Trị'),
    (4, 3,'Đỗ Minh Châu', '2000/04/15', '212860203', '0913117965', 'minhchau@gmail.com', 'Bình Nguyên, Bình Sơn, Quảng Ngãi'),
    (5, 3,'Lưu Thị Tâm Châu', '2000/04/30', '201818758', '0798429841', 'tamchau@gmail.com', 'Thanh Khê Tây, Thanh Khê, Đà Nẵng'),
    (6, 2,'Châu Ngọc Chi', '2000/08/26', '2062288046', '0819634807', 'ngocchi@gmail.com', 'Tâm Xuân Li, Núi Thành, Quảng Nam'),
    (7, 4,'Đặng Minh Chiến', '2000/06/26', '201796640', '0913464257', 'minhchien@gmail.com', 'An Khê, Thanh Khê, Đà Nẵng'),
    (8, 4,'Đặng Quang Chiến', '2000/06/03', '194628460', '0965371515', 'quangchien@gmail.com', 'Đức Ninh, Đồng Hới, Quảng Bình'),
    (9, 5,'Võ Đức Chiến', '2000/01/18', '198451692', '0989506515', 'ducchien@gmail.com', 'Hải Thái, Gio Linh, Quảng Trị'),
    (10, 5,'Bùi Hữu Nhật Chinh', '2000/08/14', '206152106', '0396802226', 'nhatchinh@gmail.com', 'Tư, Đông Giang, Quảng Nam');
    
insert into dich_vu value
-- id_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai
	(1, 'Beautiful', 200, 3, 4, 1000, 1, 1, 'Còn trống'),
    (2, 'Luxury The Point', 300, 3, 6, 1500, 1, 2, 'Còn trống'),
    (3, 'Fleur House', 100, 2, 4, 500, 2, 2, 'Còn trống'),
    (4, 'Newly Built Modern Pool', 50, 0, 2, 50, 3, 3, 'Còn trống'),
    (5, 'John Boutique', 45, 0, 2, 45, 3, 3, 'Đã thuê'),
    (6, 'The Ocean', 500, 3, 7, 1070, 1, 1, 'Còn trống'),
    (7, 'A Perfect Sea View', 250, 4, 8, 1100, 2, 2, 'Còn trống'),
    (8, 'Pandora Boutique', 800, 2, 7, 2000, 1, 1, 'Còn trống'),
    (9, 'Mường Thanh', 150, 3, 6, 800, 2, 2, 'Còn trống'),
    (10, 'Hanami', 100, 3, 5, 200, 2, 3, 'Đã thuê');
    
insert into hop_dong value
-- id_hop_dong, id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, tong_tien
	(1, 2 , 1 , 2, '2019/12/12', '2019/12/12', 500000, 1000000),
    (2, 1 , 2 , 1, '2019/02/28', '2019/03/28', 5000000, 2000000),
    (3, 3 , 4 , 5, '2019/10/01', '2019/11/01', 1000000, 7000000),
    (4, 5 , 3 , 3, '2019/10/01', '2019/10/25', 200000, 15000000),
    (5, 5 , 1 , 5, '2019/01/14', '2019/01/14', 1000000, 20000000),
    (6, 8 , 7 , 6, '2019/01/01', '2019/01/10', 500000, 15000000);
    
insert into hop_dong_chi_tiet value
-- id_hop_dong_chi_tiet, id_hop_dong, id_dich_vu_di_kem, so_luong
	(1, 1, 1, 2),
    (2, 1, 1, 1),
    (3, 2, 4, 5),
    (4, 3, 1, 4),
    (5, 4, 1, 4),
    (6, 5, 3, 4),
    (7, 6, 4, 3);
    
    
    
    
    
    
    
    
