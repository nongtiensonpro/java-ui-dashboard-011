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
public class KhachHangModel {
    private String Ma_KhachHang;
    private String tenKhachHang;
    private Date ngaySinh;
    private boolean GioiTinh;
    private String soDienThoai;
    private String diaChi;
    private boolean trangThai;

    public KhachHangModel() {
    }

    public KhachHangModel(String Ma_KhachHang, String tenKhachHang, Date ngaySinh, boolean GioiTinh, String soDienThoai, String diaChi, boolean trangThai) {
        this.Ma_KhachHang = Ma_KhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.GioiTinh = GioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public String getMa_KhachHang() {
        return Ma_KhachHang;
    }

    public void setMa_KhachHang(String Ma_KhachHang) {
        this.Ma_KhachHang = Ma_KhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
