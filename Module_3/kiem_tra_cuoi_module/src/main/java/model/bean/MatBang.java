package model.bean;

public class MatBang {
    private String id;
    private int idTrangThai;
    private double dienTich;
    private int tang;
    private int idLoaiVanPhong;
    private double giaTien;
    private String ngayBatDau;
    private String ngayKetThuc;

    public MatBang(String id, int idTrangThai, double dienTich, int tang, int idLoaiVanPhong, double giaTien, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.idTrangThai = idTrangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.idLoaiVanPhong = idLoaiVanPhong;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getIdLoaiVanPhong() {
        return idLoaiVanPhong;
    }

    public void setIdLoaiVanPhong(int idLoaiVanPhong) {
        this.idLoaiVanPhong = idLoaiVanPhong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }
}
