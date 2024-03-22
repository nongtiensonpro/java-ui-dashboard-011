/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Nong_Tien_Son
 */
public class ChiTietHoaDonModel {
    private String maHoaDonChiTiet;
    private String maHoaDon;
    private String maSanPhamChiTiet;
    private String tenSanPham;
    private int soLuong;
    private int donGia;
    private int tongTien;
  

    public ChiTietHoaDonModel() {
    }

    public ChiTietHoaDonModel(String maHoaDonChiTiet, String maHoaDon, String maSanPhamChiTiet, String tenSanPham, int soLuong, int donGia, int tongTien) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.maHoaDon = maHoaDon;
        this.maSanPhamChiTiet = maSanPhamChiTiet;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
    }

    public String getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSanPhamChiTiet() {
        return maSanPhamChiTiet;
    }

    public void setMaSanPhamChiTiet(String maSanPhamChiTiet) {
        this.maSanPhamChiTiet = maSanPhamChiTiet;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    
    
    
    
}
