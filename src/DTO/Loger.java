package DTO;

public class Loger {
    private String TenDN;
    private String MatKhau;
    private String Hoten;
    private String Email;

    public Loger() {
    }

    public Loger(String tenDN, String matKhau, String hoten, String email) {
        TenDN = tenDN;
        MatKhau = matKhau;
        Hoten = hoten;
        Email = email;
    }

    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String tenDN) {
        TenDN = tenDN;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
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
}
