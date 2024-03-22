/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Nong_Tien_Son
 */
public class HoaDonModel {
    private String maHoaDonChiTiet;
    private String maHoaDon;
    private String soDienThoaiKH;
    private String soDienThoaiNV;
    private String maKhuyenMai;
    private int tongTien;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;
    private String ghiChu;

    public HoaDonModel() {
    }

    public HoaDonModel(String maHoaDonChiTiet, String maHoaDon, String soDienThoaiKH, String soDienThoaiNV, String maKhuyenMai, int tongTien, Date ngayTao, Date ngaySua, boolean trangThai, String ghiChu) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.maHoaDon = maHoaDon;
        this.soDienThoaiKH = soDienThoaiKH;
        this.soDienThoaiNV = soDienThoaiNV;
        this.maKhuyenMai = maKhuyenMai;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
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

    public String getSoDienThoaiKH() {
        return soDienThoaiKH;
    }

    public void setSoDienThoaiKH(String soDienThoaiKH) {
        this.soDienThoaiKH = soDienThoaiKH;
    }

    public String getSoDienThoaiNV() {
        return soDienThoaiNV;
    }

    public void setSoDienThoaiNV(String soDienThoaiNV) {
        this.soDienThoaiNV = soDienThoaiNV;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean getTrangThai() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
}
