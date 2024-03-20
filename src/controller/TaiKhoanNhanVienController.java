/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import model.TaiKhoanNhanVien;
import java.util.List;
import DBConnection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TaiKhoanNhanVIenFull;
import utilities.CheckText;

/**
 *
 * @author Nong_Tien_Son
 */
public class TaiKhoanNhanVienController {

    public TaiKhoanNhanVien selectByModel(TaiKhoanNhanVien model) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        TaiKhoanNhanVien tknv = null;

        try {
            connection = DatabaseConnection.getConnection();
            StringBuilder selectQuery = new StringBuilder("SELECT Ma_NhanVien, SoDienThoai, MatKhau FROM TaiKhoanNhanVien WHERE SoDienThoai = ? AND MatKhau = ?");

            statement = connection.prepareStatement(selectQuery.toString());
            statement.setString(1, model.getSoDienThoai());
            statement.setString(2, model.getMatKhau());

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tknv = new TaiKhoanNhanVien();
                tknv.setMa_NhanVien(resultSet.getString("Ma_NhanVien"));
                tknv.setSoDienThoai(resultSet.getString("SoDienThoai"));
                tknv.setMatKhau(resultSet.getString("MatKhau"));
            }
        } catch (SQLException e) {
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
        return tknv;
    }

    public List<TaiKhoanNhanVIenFull> selectNhanVienFull(String ID_Key) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<TaiKhoanNhanVIenFull> tknvifs = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            StringBuilder selectQuery = new StringBuilder("SELECT * FROM TaiKhoanNhanVien\n"
                    + "                    INNER JOIN ChucVuNhanVien ON ChucVuNhanVien.SoDienThoai= TaiKhoanNhanVien.SoDienThoai\n"
                    + "                    INNER JOIN ThongTinNhanVien ON ThongTinNhanVien.SoDienThoai = TaiKhoanNhanVien.SoDienThoai");
            if (CheckText.checkAtExists(ID_Key)) {
                ID_Key = CheckText.removeAt(ID_Key);
                System.out.println(ID_Key);
                selectQuery.append("\nWHERE TaiKhoanNhanVien.SoDienThoai LIKE ?");
            } else if (!ID_Key.equalsIgnoreCase("KhongCoGiCa")) {
                selectQuery.append("\nWHERE TaiKhoanNhanVien.Ma_NhanVien = ?");
            }
            statement = connection.prepareStatement(selectQuery.toString());
            if (ID_Key.equalsIgnoreCase("KhongCoGiCa")) {

            } else {
                statement.setString(1,ID_Key);
            }

            resultSet = statement.executeQuery();
            TaiKhoanNhanVIenFull tknv = null;
            while (resultSet.next()) {
                tknv = new TaiKhoanNhanVIenFull();
                tknv.setMa_NhanVien(resultSet.getString("Ma_NhanVien"));
                tknv.setSoDienThoai(resultSet.getString("SoDienThoai"));
                tknv.setMatKhau(resultSet.getString("MatKhau"));
                tknv.setVaiTro(resultSet.getBoolean("VaiTro"));
                tknv.setNgayTao(resultSet.getDate("NgayTao"));
                tknv.setNgaySua(resultSet.getDate("NgaySua"));
                tknv.setTrangThai(resultSet.getBoolean("TrangThai"));
                tknv.setHoTen(resultSet.getString("HoTen"));
                tknv.setGioiTinh(resultSet.getBoolean("GioiTinh"));
                tknv.setNgaySinh(resultSet.getDate("NgaySinh"));
                tknv.setDiaChi(resultSet.getString("DiaChi"));
                tknv.setEmail(resultSet.getString("Email"));
                tknvifs.add(tknv);
            }
            return tknvifs;
        } catch (SQLException e) {
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
        return null;
    }

    public boolean themTaiKhoanNhanVien(TaiKhoanNhanVIenFull taiKhoanNhanVIenFull) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;

        try {
            connection = DatabaseConnection.getConnection();

            // INSERT into TaiKhoanNhanVien
            StringBuilder sql1 = new StringBuilder("INSERT INTO TaiKhoanNhanVien (SoDienThoai, MatKhau) VALUES (?, ?)");
            statement1 = connection.prepareStatement(sql1.toString());
            statement1.setString(1, taiKhoanNhanVIenFull.getSoDienThoai());
            statement1.setString(2, taiKhoanNhanVIenFull.getMatKhau());
            statement1.executeUpdate();

            // INSERT into ChucVuNhanVien
            StringBuilder sql2 = new StringBuilder("INSERT INTO ChucVuNhanVien (SoDienThoai, VaiTro, NgayTao, NgaySua, TrangThai) VALUES (?, ?, GETDATE(), GETDATE(), ?)");
            statement2 = connection.prepareStatement(sql2.toString());
            statement2.setString(1, taiKhoanNhanVIenFull.getSoDienThoai());
            statement2.setBoolean(2, taiKhoanNhanVIenFull.isVaiTro());
            statement2.setBoolean(3, taiKhoanNhanVIenFull.isTrangThai());
            statement2.executeUpdate();

            // INSERT into ThongTinNhanVien
            StringBuilder sql3 = new StringBuilder("INSERT INTO ThongTinNhanVien (SoDienThoai, HoTen, GioiTinh, NgaySinh, DiaChi, Email) VALUES (?, ?, ?, ?, ?, ?)");
            statement3 = connection.prepareStatement(sql3.toString());
            statement3.setString(1, taiKhoanNhanVIenFull.getSoDienThoai());
            statement3.setString(2, taiKhoanNhanVIenFull.getHoTen());
            statement3.setBoolean(3, taiKhoanNhanVIenFull.isGioiTinh());
            statement3.setDate(4, taiKhoanNhanVIenFull.getNgaySinh());
            statement3.setString(5, taiKhoanNhanVIenFull.getDiaChi());
            statement3.setString(6, taiKhoanNhanVIenFull.getEmail());
            statement3.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (statement3 != null) {
                    statement3.close();
                }
                if (statement2 != null) {
                    statement2.close();
                }
                if (statement1 != null) {
                    statement1.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean capNhapTaiKhoanNhanVien(TaiKhoanNhanVIenFull taiKhoanNhanVIenFull) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;

        try {
            connection = DatabaseConnection.getConnection();

            // UPDATE TaiKhoanNhanVien
            StringBuilder sql1 = new StringBuilder("UPDATE TaiKhoanNhanVien SET "
                    + "MatKhau = ?");
            sql1.append("WHERE SoDienThoai = ?\n");
            statement1 = connection.prepareStatement(sql1.toString());
            statement1.setString(1, taiKhoanNhanVIenFull.getMatKhau());
            statement1.setString(2, taiKhoanNhanVIenFull.getSoDienThoai());
            int ketQua1 = statement1.executeUpdate();

            StringBuilder sql2 = new StringBuilder("UPDATE ThongTinNhanVien SET "
                    + "HoTen = ? ,"
                    + "GioiTinh = ? ,"
                    + "NgaySinh = ? ,"
                    + "DiaChi = ? ,"
                    + "Email = ? "
                    + "WHERE SoDienThoai = ?\n");
            statement2 = connection.prepareCall(sql2.toString());
            statement2.setString(1, taiKhoanNhanVIenFull.getHoTen());
            statement2.setBoolean(2, taiKhoanNhanVIenFull.isGioiTinh());
            statement2.setDate(3, taiKhoanNhanVIenFull.getNgaySinh());
            statement2.setString(4, taiKhoanNhanVIenFull.getDiaChi());
            statement2.setString(5, taiKhoanNhanVIenFull.getEmail());
            statement2.setString(6, taiKhoanNhanVIenFull.getSoDienThoai());
            int ketQua2 = statement2.executeUpdate();
            StringBuilder sql3 = new StringBuilder("UPDATE ChucVuNhanVien SET "
                    + "VaiTro = ?,"
                    + "NgaySua = ? ,"
                    + "TrangThai = ? "
                    + "WHERE SoDienThoai = ?");
            statement3 = connection.prepareStatement(sql3.toString());
            statement3.setBoolean(1, taiKhoanNhanVIenFull.isVaiTro());
            statement3.setDate(2, taiKhoanNhanVIenFull.getNgaySua());
            statement3.setBoolean(3, taiKhoanNhanVIenFull.isTrangThai());
            statement3.setString(4, taiKhoanNhanVIenFull.getSoDienThoai());
            int ketQua3 = statement3.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (statement1 != null) {
                    statement1.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean capNhatTaiKhoanNhanVienTheoSoDienThoai(TaiKhoanNhanVIenFull taiKhoanNhanVIenFull) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;

        try {
            connection = DatabaseConnection.getConnection();

            // UPDATE TaiKhoanNhanVien
//            StringBuilder sql1 = new StringBuilder("UPDATE TaiKhoanNhanVien SET MatKhau = ? WHERE SoDienThoai = ?");
//            statement1 = connection.prepareStatement(sql1.toString());
//            statement1.setString(1, taiKhoanNhanVIenFull.getMatKhau());
//            statement1.setString(2, taiKhoanNhanVIenFull.getSoDienThoai());
//            statement1.executeUpdate();

            // UPDATE ChucVuNhanVien
            StringBuilder sql2 = new StringBuilder("UPDATE ChucVuNhanVien SET VaiTro = ?, NgaySua = GETDATE(), TrangThai = ? WHERE SoDienThoai = ?");
            statement2 = connection.prepareStatement(sql2.toString());
            statement2.setBoolean(1, taiKhoanNhanVIenFull.isVaiTro());
            statement2.setBoolean(2, taiKhoanNhanVIenFull.isTrangThai());
            statement2.setString(3, taiKhoanNhanVIenFull.getSoDienThoai());
            statement2.executeUpdate();

            // UPDATE ThongTinNhanVien
            StringBuilder sql3 = new StringBuilder("UPDATE ThongTinNhanVien SET HoTen = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Email = ? WHERE SoDienThoai = ?");
            statement3 = connection.prepareStatement(sql3.toString());
            statement3.setString(1, taiKhoanNhanVIenFull.getHoTen());
            statement3.setBoolean(2, taiKhoanNhanVIenFull.isGioiTinh());
            statement3.setDate(3, taiKhoanNhanVIenFull.getNgaySinh());
            statement3.setString(4, taiKhoanNhanVIenFull.getDiaChi());
            statement3.setString(5, taiKhoanNhanVIenFull.getEmail());
            statement3.setString(6, taiKhoanNhanVIenFull.getSoDienThoai());
            statement3.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (statement3 != null) {
                    statement3.close();
                }
                if (statement2 != null) {
                    statement2.close();
                }
                if (statement1 != null) {
                    statement1.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
