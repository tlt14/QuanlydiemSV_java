package DTO;

public class GiangVien {
    private int MaGV;
    private String Hoten;
    private String Email;
    private String SDT;
    private int MonGiangDay;
    private String NgaySinh;
    private String DiaChi;
    private boolean Gioitinh;

    public GiangVien() {
    }

    public GiangVien(int maGV, String hoten, String email, String SDT, int monGiangDay, String ngaySinh, String diaChi, boolean gioitinh) {
        MaGV = maGV;
        Hoten = hoten;
        Email = email;
        this.SDT = SDT;
        MonGiangDay = monGiangDay;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        Gioitinh = gioitinh;
    }

    public int getMaGV() {
        return MaGV;
    }

    public void setMaGV(int maGV) {
        MaGV = maGV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getMonGiangDay() {
        return MonGiangDay;
    }

    public void setMonGiangDay(int monGiangDay) {
        MonGiangDay = monGiangDay;
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
