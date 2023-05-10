package DTO;

public class Khoa {
    private String TenKhoa;
    private String MaKhoa;
    private String SDT;

    public Khoa() {
    }

    public Khoa(String tenKhoa, String maKhoa, String SDT) {
        TenKhoa = tenKhoa;
        MaKhoa = maKhoa;
        this.SDT = SDT;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        TenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
