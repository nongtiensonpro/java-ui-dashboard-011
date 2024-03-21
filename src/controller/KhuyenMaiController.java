/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai;


/**
 *
 * @author Khanh
 */
public class KhuyenMaiController {
    public List<KhuyenMai> timKiemTatCaKuyenMai() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<KhuyenMai> listKhanhHang = new ArrayList<>();
        KhuyenMai khuyenmai = null;
        try {
            connection = connection = DatabaseConnection.getConnection();

            String cauLenhTimKiem = "SELECT * FROM KhuyenMai";
            statement = connection.prepareCall(cauLenhTimKiem);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                khuyenmai = new KhuyenMai();
                khuyenmai.setMaKhuyenMai(resultSet.getString("MaKhuyenMai"));
                khuyenmai.setTenKhuyenMai(resultSet.getString("TenKhuyenMai"));
                khuyenmai.setGiaTri(resultSet.getInt("GiaTri"));
                khuyenmai.setLoaiKhuyenMai(resultSet.getBoolean("LoaiKhuyenMai"));
                khuyenmai.setNgayBatDau(resultSet.getDate("NgayBatDau"));
                khuyenmai.setNgayKetThuc(resultSet.getDate("NgayKetThuc"));
                khuyenmai.setTrangThai(resultSet.getBoolean("TrangThai"));
                listKhanhHang.add(khuyenmai);
            }
            return listKhanhHang;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public boolean capNhatThongTinKhuyenMai(KhuyenMai khachHangModel) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhCapNhat = "UPDATE KhuyenMai SET TenKhuyenMai = ?, GiaTri = ?, LoaiKhuyenMai = ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ? WHERE MaKhuyenMai = ?";
            statement = connection.prepareStatement(cauLenhCapNhat);

            statement.setString(1, khachHangModel.getTenKhuyenMai());
            statement.setInt(2, khachHangModel.getGiaTri());
            statement.setBoolean(3, khachHangModel.isLoaiKhuyenMai());
            statement.setDate(4, (Date) khachHangModel.getNgayBatDau());
            statement.setDate(5, (Date) khachHangModel.getNgayKetThuc());
            statement.setBoolean(6, khachHangModel.isTrangThai());
            statement.setString(7, khachHangModel.getMaKhuyenMai());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public boolean themKhuyenMai(KhuyenMai khachHangModel) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhThem = "INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, GiaTri, LoaiKhuyenMai, NgayBatDau, NgayKetThuc, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(cauLenhThem);

            statement.setString(1, khachHangModel.getMaKhuyenMai());
            statement.setString(2, khachHangModel.getTenKhuyenMai());
            statement.setInt(3,khachHangModel.getGiaTri());
            statement.setBoolean(4, khachHangModel.isLoaiKhuyenMai());
            statement.setDate(5, (Date) khachHangModel.getNgayBatDau());
            statement.setDate(6, (Date) khachHangModel.getNgayKetThuc());
            statement.setBoolean(7, khachHangModel.isTrangThai());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public List<KhuyenMai> timKiemKhuyenMaitheoMa(String maKhuyenMai) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        KhuyenMai khachHangModel = null;
        List<KhuyenMai> listKhanhHang = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhTimKiem = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai = ?";
            statement = connection.prepareStatement(cauLenhTimKiem);
            statement.setString(1, maKhuyenMai);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                khachHangModel = new KhuyenMai();
                
                khachHangModel.setTenKhuyenMai(resultSet.getString("TenKhuyenMai"));
                khachHangModel.setGiaTri(resultSet.getInt("GiaTri"));
                khachHangModel.setLoaiKhuyenMai(resultSet.getBoolean("LoaiKhuyenMai"));
                khachHangModel.setNgayBatDau(resultSet.getDate("NgayBatDau"));
                khachHangModel.setNgayKetThuc(resultSet.getDate("NgayKetThuc"));
                khachHangModel.setTrangThai(resultSet.getBoolean("TrangThai"));
                listKhanhHang.add(khachHangModel);
            }
            return listKhanhHang;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return listKhanhHang;
    }
}
