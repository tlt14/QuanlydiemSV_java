package DTO;

public class Lop {
    private String MaLop;
    private String TenLop;
    private String MaKhoa;
    private String KhoaHoc;
    public Lop() {
    }

    public Lop(String maLop, String tenLop, String maKhoa, String khoaHoc) {
        MaLop = maLop;
        TenLop = tenLop;
        MaKhoa = maKhoa;
        KhoaHoc = khoaHoc;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        KhoaHoc = khoaHoc;
    }
}
