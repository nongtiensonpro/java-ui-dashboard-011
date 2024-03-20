/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Nong_Tien_Son
 */
public class MaXacNhanTaiKhoan {
    private String maMaXacNhan;
    private String maNhanVien;
    private Date ngaySuDung;
    private Boolean trangThai;

    public MaXacNhanTaiKhoan() {
    }

    public MaXacNhanTaiKhoan(String maMaXacNhan, Boolean trangThai) {
        this.maMaXacNhan = maMaXacNhan;
        this.trangThai = trangThai;
    }
    
    public MaXacNhanTaiKhoan(String maMaXacNhan, String maNhanVien, Date ngaySuDung, Boolean trangThai) {
        this.maMaXacNhan = maMaXacNhan;
        this.maNhanVien = maNhanVien;
        this.ngaySuDung = ngaySuDung;
        this.trangThai = trangThai;
    }

    public String getMaMaXacNhan() {
        return maMaXacNhan;
    }

    public void setMaMaXacNhan(String maMaXacNhan) {
        this.maMaXacNhan = maMaXacNhan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(Date ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
