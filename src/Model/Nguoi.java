package Model;

import java.sql.Date;

public class Nguoi {
    private int id;
    private String hoTen;
    private Date ngaySinh;
    private String email;
    private String tel;
    private String diaChi;

    public Nguoi(){

    }

    public Nguoi(String hoTen, Date ngaySinh, String email, String tel, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.tel = tel;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return String.format("%s", hoTen);
    }
}
