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
import model.HoaDonModel;

/**
 *
 * @author Nong_Tien_Son
 */
public class HoaDonController {

    public List<HoaDonModel> timKiemTatCaHoaDon() {
        HoaDonModel hoaDonModel = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<HoaDonModel> listHoaDonModel = new ArrayList<>();
        try {
            String cauLenhTimKiem = "SELECT * FROM HoaDon";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhTimKiem);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hoaDonModel = new HoaDonModel();
                hoaDonModel.setMaHoaDon(resultSet.getString("MaHoaDon"));
                hoaDonModel.setSoDienThoaiNV(resultSet.getString("SDTNhanVien"));
                hoaDonModel.setSoDienThoaiKH(resultSet.getString("SDTKhachHang"));
                hoaDonModel.setMaKhuyenMai(resultSet.getString("MaKhuyenMai"));
                hoaDonModel.setTongTien(resultSet.getInt("TongTien"));
                hoaDonModel.setNgayTao(resultSet.getDate("NgayTao"));
                hoaDonModel.setNgaySua(resultSet.getDate("NgaySua"));
                hoaDonModel.setTrangThai(resultSet.getBoolean("TrangThai"));
                hoaDonModel.setGhiChu(resultSet.getString("GhiChu"));
                listHoaDonModel.add(hoaDonModel);
            }
            return listHoaDonModel;
        } catch (Exception e) {
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

    public List<HoaDonModel> timKiemTatCaHoaTreo() {
        HoaDonModel hoaDonModel = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<HoaDonModel> listHoaDonModel = new ArrayList<>();
        try {
            String cauLenhTimKiem = "SELECT * FROM HoaDon WHERE TrangThai = 0";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhTimKiem);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hoaDonModel = new HoaDonModel();
                hoaDonModel.setMaHoaDon(resultSet.getString("MaHoaDon"));
                hoaDonModel.setSoDienThoaiNV(resultSet.getString("SDTNhanVien"));
                hoaDonModel.setSoDienThoaiKH(resultSet.getString("SDTKhachHang"));
                hoaDonModel.setTongTien(resultSet.getInt("TongTien"));
                hoaDonModel.setNgayTao(resultSet.getDate("NgayTao"));
                hoaDonModel.setNgaySua(resultSet.getDate("NgaySua"));
                hoaDonModel.setMaKhuyenMai(resultSet.getString("MaKhuyenMai"));
                hoaDonModel.setTrangThai(resultSet.getBoolean("TrangThai"));
                hoaDonModel.setGhiChu(resultSet.getString("GhiChu"));
                listHoaDonModel.add(hoaDonModel);
            }
            return listHoaDonModel;
        } catch (Exception e) {
            e.printStackTrace();
            return listHoaDonModel;
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

    public int capNhatHoaDonTreo(HoaDonModel hoaDonModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            String cauLenhCapNhat = "UPDATE HoaDon SET SDTNhanVien = ?, "
                    + "SDTKhachHang = ?, MaKhuyenMai = ?, TongTien = ?, NgaySua = ?, "
                    + "TrangThai = ?, GhiChu = ? WHERE MaHoaDon = ?";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhCapNhat);
            statement.setString(1, hoaDonModel.getSoDienThoaiNV());
            statement.setString(2, hoaDonModel.getSoDienThoaiKH());
            statement.setString(3, hoaDonModel.getMaKhuyenMai());
            statement.setInt(4, hoaDonModel.getTongTien());
            statement.setDate(5, (Date) hoaDonModel.getNgaySua());
            statement.setBoolean(6, false);
            statement.setString(7, hoaDonModel.getGhiChu());
            statement.setString(8, hoaDonModel.getMaHoaDon());
            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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
        return result;
    }
    
    public boolean capNhatHoaDonThanhToanHoaDon(HoaDonModel hoaDonModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String cauLenhCapNhat = "UPDATE HoaDon SET SDTNhanVien = ?, "
                    + "SDTKhachHang = ?, MaKhuyenMai = ?, TongTien = ?, NgaySua = ?, "
                    + "TrangThai = 1, GhiChu = ? WHERE MaHoaDon = ?";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhCapNhat);
            statement.setString(1, hoaDonModel.getSoDienThoaiNV());
            statement.setString(2, hoaDonModel.getSoDienThoaiKH());
            statement.setString(3, hoaDonModel.getMaKhuyenMai());
            statement.setInt(4, hoaDonModel.getTongTien());
            statement.setDate(5, (Date) hoaDonModel.getNgaySua());
            statement.setString(6, hoaDonModel.getGhiChu());
            statement.setString(7, hoaDonModel.getMaHoaDon());
            statement.executeUpdate();
            return true;
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
    
    
    public boolean themHoaDonMoi (HoaDonModel hoaDonModel){
        HoaDonModel donModel = null;
         Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String cauLenhThem="INSERT INTO HoaDon ( MaHoaDon, SDTNhanVien, SDTKhachHang,MaKhuyenMai, TongTien, NgayTao, NgaySua, TrangThai, GhiChu)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
             connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(cauLenhThem);
            statement.setString(1, hoaDonModel.getMaHoaDon());
            statement.setString(2, hoaDonModel.getSoDienThoaiNV());
            statement.setString(3, hoaDonModel.getSoDienThoaiKH());
            statement.setString(4, hoaDonModel.getMaKhuyenMai());
            statement.setInt(5, hoaDonModel.getTongTien());
            statement.setDate(6, (Date) hoaDonModel.getNgayTao());
            statement.setDate(7, (Date) hoaDonModel.getNgayTao());
            statement.setBoolean(8, false);
            statement.setString(9, hoaDonModel.getGhiChu());
            statement.executeUpdate();
            return true;
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
