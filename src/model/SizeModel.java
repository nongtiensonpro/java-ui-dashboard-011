/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENHATLINH
 */
public class SizeModel {
    private String maSize;
    private int soSize;
    private String moTa;

    public SizeModel() {
    }

    public SizeModel(String maSize, int size, String moTa) {
        this.maSize = maSize;
        this.soSize = size;
        this.moTa = moTa;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public int getSoSize() {
        return soSize;
    }

    public void setSoSize(int soSize) {
        this.soSize = soSize;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
}
