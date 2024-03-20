package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nong_Tien_Son
 */
public class TaiKhoanNhanVien {

    private String Ma_NhanVien;
    private String SoDienThoai;
    private String MatKhau;

    public TaiKhoanNhanVien() {
    }

    public TaiKhoanNhanVien( String SoDienThoai, String MatKhau) {
        this.SoDienThoai = SoDienThoai;
        this.MatKhau = MatKhau;
    }

    public TaiKhoanNhanVien(String Ma_NhanVien, String SoDienThoai, String MatKhau) {
        this.Ma_NhanVien = Ma_NhanVien;
        this.SoDienThoai = SoDienThoai;
        this.MatKhau = MatKhau;
    }

    public String getMa_NhanVien() {
        return Ma_NhanVien;
    }

    public void setMa_NhanVien(String Ma_NhanVien) {
        this.Ma_NhanVien = Ma_NhanVien;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

}
