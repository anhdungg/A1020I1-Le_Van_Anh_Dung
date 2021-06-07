package model.bean;

public class TrangThai {
    private int id;
    private String tenTrangThai;

    public TrangThai(int id, String tenTrangThai) {
        this.id = id;
        this.tenTrangThai = tenTrangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
