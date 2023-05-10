package DTO;

public class Monhoc {
    private int MaMH;
    private String TenMH;
    private int STC;
    private String HinhThucThi;
    private int HocKy;
    private String PhongHoc;

    public Monhoc() {
    }

    public Monhoc(int maMH, String tenMH, int STC, String hinhThucThi, int hocKy, String phongHoc) {
        MaMH = maMH;
        TenMH = tenMH;
        this.STC = STC;
        HinhThucThi = hinhThucThi;
        HocKy = hocKy;
        PhongHoc = phongHoc;
    }

    public int getMaMH() {
        return MaMH;
    }

    public void setMaMH(int maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public int getSTC() {
        return STC;
    }

    public void setSTC(int STC) {
        this.STC = STC;
    }

    public String getHinhThucThi() {
        return HinhThucThi;
    }

    public void setHinhThucThi(String hinhThucThi) {
        HinhThucThi = hinhThucThi;
    }

    public int getHocKy() {
        return HocKy;
    }

    public void setHocKy(int hocKy) {
        HocKy = hocKy;
    }

    public String getPhongHoc() {
        return PhongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        PhongHoc = phongHoc;
    }
}
