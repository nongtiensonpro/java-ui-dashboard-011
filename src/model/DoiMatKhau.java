/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nong_Tien_Son
 */
public class DoiMatKhau {
    private String maXacNhan;
    private String SoDienThoai;
    private String matKhauNew;

    public DoiMatKhau() {
    }

    public DoiMatKhau(String maXacNhan, String SoDienThoai, String matKhauNew) {
        this.maXacNhan = maXacNhan;
        this.SoDienThoai = SoDienThoai;
        this.matKhauNew = matKhauNew;
    }

    public String getMaXacNhan() {
        return maXacNhan;
    }

    public void setMaXacNhan(String maXacNhan) {
        this.maXacNhan = maXacNhan;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getMatKhauNew() {
        return matKhauNew;
    }

    public void setMatKhauNew(String matKhauNew) {
        this.matKhauNew = matKhauNew;
    }
    
    
}
