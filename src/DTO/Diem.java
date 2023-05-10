package DTO;

public class Diem {
    private int MaSV;
    private int MaMH;
    private int LanThi;
    private int Heso;
    private float Diem;
    private boolean TrangThai;
    private String TenSV;

    public Diem() {
    }

    public Diem(int maSV,String tenSV, int maMH, int lanThi, int heso, float diem, boolean trangThai) {
        MaSV = maSV;
        MaMH = maMH;
        LanThi = lanThi;
        Heso = heso;
        Diem = diem;
        TrangThai = trangThai;
        TenSV=tenSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public int getMaMH() {
        return MaMH;
    }

    public void setMaMH(int maMH) {
        MaMH = maMH;
    }

    public int getLanThi() {
        return LanThi;
    }

    public void setLanThi(int lanThi) {
        LanThi = lanThi;
    }

    public int getHeso() {
        return Heso;
    }

    public void setHeso(int heso) {
        Heso = heso;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float diem) {
        Diem = diem;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        if(trangThai==1){
            TrangThai=true;
        }else{
            TrangThai=false;
        }
    }
}
