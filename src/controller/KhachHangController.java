/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KhachHangModel;

/**
 *
 * @author Nong_Tien_Son
 */
public class KhachHangController {

    public List<KhachHangModel> timKiemTatCaKhachHang() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<KhachHangModel> listKhanhHang = new ArrayList<>();
        KhachHangModel khachHangModel = null;
        try {
            connection = connection = DatabaseConnection.getConnection();

            String cauLenhTimKiem = "SELECT * FROM KhachHang";
            statement = connection.prepareCall(cauLenhTimKiem);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                khachHangModel = new KhachHangModel();
                khachHangModel.setMa_KhachHang(resultSet.getString("Ma_KhachHang"));
                khachHangModel.setTenKhachHang(resultSet.getString("Ten"));
                khachHangModel.setNgaySinh(resultSet.getDate("NgaySinh"));
                khachHangModel.setGioiTinh(resultSet.getBoolean("GioiTinh"));
                khachHangModel.setSoDienThoai(resultSet.getString("SDT"));
                khachHangModel.setDiaChi(resultSet.getString("DiaChi"));
                khachHangModel.setTrangThai(resultSet.getBoolean("TrangThai"));
                listKhanhHang.add(khachHangModel);
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

    public boolean capNhatThongTinKhachHang(KhachHangModel khachHangModel) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhCapNhat = "UPDATE KhachHang SET Ten = ?, NgaySinh = ?, GioiTinh = ?, SDT = ?, DiaChi = ?, TrangThai = ? WHERE Ma_KhachHang = ?";
            statement = connection.prepareStatement(cauLenhCapNhat);

            statement.setString(1, khachHangModel.getTenKhachHang());
            statement.setDate(2, new java.sql.Date(khachHangModel.getNgaySinh().getTime()));
            statement.setBoolean(3, khachHangModel.isGioiTinh());
            statement.setString(4, khachHangModel.getSoDienThoai());
            statement.setString(5, khachHangModel.getDiaChi());
            statement.setBoolean(6, khachHangModel.isTrangThai());
            statement.setString(7, khachHangModel.getMa_KhachHang());

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

    public List<KhachHangModel> timKiemKhachHangTheoSDT(String soDienThoai) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        KhachHangModel khachHangModel = null;
        List<KhachHangModel> listKhanhHang = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhTimKiem = "SELECT * FROM KhachHang WHERE SDT = ?";
            statement = connection.prepareStatement(cauLenhTimKiem);
            statement.setString(1, soDienThoai);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                khachHangModel = new KhachHangModel();
                khachHangModel.setMa_KhachHang(resultSet.getString("Ma_KhachHang"));
                khachHangModel.setTenKhachHang(resultSet.getString("Ten"));
                khachHangModel.setNgaySinh(resultSet.getDate("NgaySinh"));
                khachHangModel.setGioiTinh(resultSet.getBoolean("GioiTinh"));
                khachHangModel.setSoDienThoai(resultSet.getString("SDT"));
                khachHangModel.setDiaChi(resultSet.getString("DiaChi"));
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

    public boolean themKhachHang(KhachHangModel khachHangModel) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            String cauLenhThem = "INSERT INTO KhachHang (Ma_KhachHang, Ten, NgaySinh, GioiTinh, SDT, DiaChi, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(cauLenhThem);

            statement.setString(1, khachHangModel.getMa_KhachHang());
            statement.setString(2, khachHangModel.getTenKhachHang());
            statement.setDate(3, new java.sql.Date(khachHangModel.getNgaySinh().getTime()));
            statement.setBoolean(4, khachHangModel.isGioiTinh());
            statement.setString(5, khachHangModel.getSoDienThoai());
            statement.setString(6, khachHangModel.getDiaChi());
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

}
