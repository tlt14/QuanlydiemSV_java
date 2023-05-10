package DTO;

public class Student {
    private int MaSV;
    private String Hoten;
    private String MaLop;
    private String SDT;
    private String Hedaotao;
    private String NgaySinh;
    private String DiaChi;
    private boolean Gioitinh;

    public Student() {
    }

    public Student(int maSV, String hoten, String maLop, String SDT, String hedaotao, String ngaySinh, String diaChi, boolean gioitinh) {
        MaSV = maSV;
        Hoten = hoten;
        MaLop = maLop;
        this.SDT = SDT;
        Hedaotao = hedaotao;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        Gioitinh = gioitinh;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getHedaotao() {
        return Hedaotao;
    }

    public void setHedaotao(String hedaotao) {
        Hedaotao = hedaotao;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        if(gioitinh==1){
            Gioitinh=true;
        }else{
            Gioitinh=false;
        }
    }
}
