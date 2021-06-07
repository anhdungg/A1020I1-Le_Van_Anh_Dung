package model.bean;

public class LoaiVanPhong {
    private int id;
    private String tenLoaiVanPhong;

    public LoaiVanPhong(int id, String tenLoaiVanPhong) {
        this.id = id;
        this.tenLoaiVanPhong = tenLoaiVanPhong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiVanPhong() {
        return tenLoaiVanPhong;
    }

    public void setTenLoaiVanPhong(String tenLoaiVanPhong) {
        this.tenLoaiVanPhong = tenLoaiVanPhong;
    }
}
