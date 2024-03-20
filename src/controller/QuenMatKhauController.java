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
import model.DoiMatKhau;
import model.MaXacNhanTaiKhoan;
import utilities.CheckText;

/**
 *
 * @author Nong_Tien_Son
 */
public class QuenMatKhauController {

    public List<MaXacNhanTaiKhoan> timMaXacNhan(String maXacNhanInput) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        MaXacNhanTaiKhoan mxntk = null;
        List<MaXacNhanTaiKhoan> listMaQuenMatKhau = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            StringBuffer selectQuery = new StringBuffer("SELECT *"
                    + " FROM MaXacNhanTaiKhoan ");

            if (CheckText.checkAtExists(maXacNhanInput)) {
                selectQuery.append("WHERE SoDienThoai = ?");
            } else if (maXacNhanInput.equals("") == false) {

                selectQuery.append("WHERE Ma_MaXacNhan = ?");
            }
            statement = connection.prepareCall(selectQuery.toString());
            if (CheckText.checkAtExists(maXacNhanInput)) {
                maXacNhanInput = CheckText.removeAt(maXacNhanInput);
                statement.setString(1, maXacNhanInput);
            } else if (maXacNhanInput.equals("") == false) {
                statement.setString(1, maXacNhanInput);
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                mxntk = new MaXacNhanTaiKhoan();
                mxntk.setMaMaXacNhan(resultSet.getString("Ma_MaXacNhan"));
                mxntk.setMaNhanVien(resultSet.getString("SoDienThoai"));
                mxntk.setNgaySuDung(resultSet.getDate("NgaySuDung"));
                mxntk.setTrangThai(resultSet.getBoolean("TrangThai"));
                listMaQuenMatKhau.add(mxntk);
            }
            return listMaQuenMatKhau;
        } catch (Exception e) {

            e.printStackTrace();
            return listMaQuenMatKhau;
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

    public boolean themMaQuenMatKhau() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "INSERT INTO MaXacNhanTaiKhoan(TrangThai)\n"
                    + "VALUES(1)";
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareCall(sql);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean voHieuHoaMaXacNhan(String maMuonHuyInput) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();

            String sql = "UPDATE MaXacNhanTaiKhoan \n"
                    + "SET TrangThai = 0  "
                    + "WHERE Ma_MaXacNhan= ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, maMuonHuyInput);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean capNhatMatKhau(DoiMatKhau doiMatKhau) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();

            // Tạo câu lệnh SQL
            String sql = "UPDATE MaXacNhanTaiKhoan "
                    + "SET TrangThai = 0, "
                    + "    SoDienThoai = ?, "
                    + "    NgaySuDung = GETDATE() "
                    + "WHERE Ma_MaXacNhan = ?; "
                    + "UPDATE TaiKhoanNhanVien "
                    + "SET MatKhau = ? "
                    + "WHERE SoDienThoai = ?";

            // Chuẩn bị câu lệnh
            statement = connection.prepareStatement(sql);

            // Thiết lập tham số cho câu lệnh SQL
            statement.setString(1, doiMatKhau.getSoDienThoai());
            statement.setString(2, doiMatKhau.getMaXacNhan());
            statement.setString(3, doiMatKhau.getMatKhauNew());
            statement.setString(4, doiMatKhau.getSoDienThoai());

            // Thực thi câu lệnh
            int rowsAffected = statement.executeUpdate();

            // Kiểm tra xem có dòng nào bị ảnh hưởng hay không
            if (rowsAffected > 0) {
                return true; // Trả về true nếu có dòng bị ảnh hưởng
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // Trả về false nếu không có dòng nào bị ảnh hưởng
    }

}
