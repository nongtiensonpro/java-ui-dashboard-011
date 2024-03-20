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
import model.HangModel;

/**
 *
 * @author Khanh
 */
public class HangController {

    public List<HangModel> timkiemHang() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        HangModel hang = null;

        List<HangModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from Hang");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new HangModel();
                hang.setMaHang(resultSet.getString("MaHang"));
                hang.setTenHang(resultSet.getString("TenHang"));
                hang.setTrangThai(resultSet.getBoolean("TrangThai"));
                hang.setNgayTao(resultSet.getDate("NgayTao"));
                hang.setNgaySua(resultSet.getDate("NgaySua"));
                hang.setMoTa(resultSet.getString("MoTa"));
                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
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

    public Boolean themHang(HangModel hangtruyenvao) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhthem = new String("INSERT INTO [dbo].[Hang]\n"
                    + "           ([MaHang]\n"
                    + "           ,[TrangThai]\n"
                    + "           ,[NgayTao]\n"
                    + "           ,[NgaySua]\n"
                    + "           ,[MoTa],"
                    + "TenHang)\n"
                    + "     VALUES\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,"
                    + "?)");
            statement = connection.prepareStatement(caulenhthem);
            statement.setString(1, hangtruyenvao.getMaHang());
            statement.setBoolean(2, hangtruyenvao.getTrangThai());
            statement.setDate(3, hangtruyenvao.getNgayTao());
            statement.setDate(4, hangtruyenvao.getNgaySua());
            statement.setString(5, hangtruyenvao.getMoTa());
            statement.setString(6, hangtruyenvao.getTenHang());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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

    public Boolean suaHang(HangModel hangModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[Hang]\n"
                    + "   SET \n"
                    + "      [TrangThai] = ?\n"
                    + "      ,[NgayTao] = ?\n"
                    + "      ,[NgaySua] = ?\n"
                    + "      ,[MoTa] = ?"
                    + "       ,TenHang = ?\n"
                    + " WHERE MaHang=?");
            statement = connection.prepareStatement(caulenhUpdate);
//             statement.setString(1, hangModel.getMaHang());
            statement.setBoolean(1, hangModel.getTrangThai());
            statement.setDate(2, hangModel.getNgayTao());
            statement.setDate(3, hangModel.getNgaySua());
            System.out.println(hangModel.getNgaySua() + "MeoMeo");
            statement.setString(4, hangModel.getMoTa());
            statement.setString(5, hangModel.getTenHang());
            statement.setString(6, hangModel.getMaHang());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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

    public List<HangModel> timKiemHangTheoMa(String matimkiem) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        HangModel hang = null;

        List<HangModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from Hang where MaHang like ?");
            statement = connection.prepareStatement(caulenhtruyvan);
            statement.setString(1, matimkiem);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new HangModel();
                hang.setMaHang(resultSet.getString("MaHang"));
                hang.setTenHang(resultSet.getString("TenHang"));
                hang.setTrangThai(resultSet.getBoolean("TrangThai"));
                hang.setNgayTao(resultSet.getDate("NgayTao"));
                hang.setNgaySua(resultSet.getDate("NgaySua"));
                hang.setMoTa(resultSet.getString("MoTa"));
                danhsachHang.add(hang);
            }
            return danhsachHang;
        } catch (Exception e) {
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
}
