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
import model.NhaSanXuatModel;

/**
 *
 * @author Khanh
 */
public class NhaSanXuatController {

    public List<NhaSanXuatModel> timkiemNSX() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        NhaSanXuatModel nsx = null;

        List<NhaSanXuatModel> danhsachNSX = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from NhaSanXuat");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                nsx = new NhaSanXuatModel();
                nsx.setMaNSX(resultSet.getString("MaNSX"));
                nsx.setTenNSX(resultSet.getString("TenNSX"));
                nsx.setQuocGia(resultSet.getString("QuocGia"));
                nsx.setTrangThai(resultSet.getBoolean("TrangThai"));
                nsx.setNgayTao(resultSet.getDate("NgayTao"));
                nsx.setNgaySua(resultSet.getDate("NgaySua"));
                nsx.setMoTa(resultSet.getString("MoTa"));
                danhsachNSX.add(nsx);
            }
            return danhsachNSX;
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

    public Boolean themNSX(NhaSanXuatModel nsxTruyenVao) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhthem = new String("INSERT INTO [dbo].[NhaSanXuat]\n"
                    + "           ([MaNSX]\n"
                    + "           ,[QuocGia]\n"
                    + "           ,[TrangThai]\n"
                    + "           ,[NgayTao]\n"
                    + "           ,[NgaySua]\n"
                    + "           ,[MoTa],"
                    + "TenNSX)\n"
                    + "     VALUES\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,"
                    + "?)");
            statement = connection.prepareStatement(caulenhthem);
            statement.setString(1, nsxTruyenVao.getMaNSX());
            statement.setString(2, nsxTruyenVao.getQuocGia());
            statement.setBoolean(3, nsxTruyenVao.getTrangThai());
            statement.setDate(4, nsxTruyenVao.getNgayTao());
            statement.setDate(5, nsxTruyenVao.getNgaySua());
            statement.setString(6, nsxTruyenVao.getMoTa());
            statement.setString(7, nsxTruyenVao.getTenNSX());
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

    public Boolean suaNSX(NhaSanXuatModel nsxModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[NhaSanXuat]\n"
                    + "   SET \n"
                    + "      [QuocGia] = ?\n"
                    + "      ,[TrangThai] = ?\n"
                    + "      ,[NgayTao] = ?\n"
                    + "      ,[NgaySua] = ?\n"
                    + "      ,[MoTa] = ?"
                    + "       ,TenNSX = ?\n"
                    + " WHERE MaNSX=?");
            statement = connection.prepareStatement(caulenhUpdate);
//             statement.setString(1, hangModel.getMaHang());
            statement.setString(1, nsxModel.getQuocGia());
            statement.setBoolean(2, nsxModel.getTrangThai());
            statement.setDate(3, nsxModel.getNgayTao());
            statement.setDate(4, nsxModel.getNgaySua());
            System.out.println(nsxModel.getNgaySua() + "MeoMeo");
            statement.setString(5, nsxModel.getMoTa());
            statement.setString(6, nsxModel.getTenNSX());
            statement.setString(7, nsxModel.getMaNSX());
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

    public List<NhaSanXuatModel> timKiemNSXTheoMa(String matimkiem) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        NhaSanXuatModel hang = null;

        List<NhaSanXuatModel> danhsachHang = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from NhaSanXuat where MaNSX like ?");
            statement = connection.prepareStatement(caulenhtruyvan);
            statement.setString(1, matimkiem);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hang = new NhaSanXuatModel();
                hang.setMaNSX(resultSet.getString("MaNSX"));
                hang.setTenNSX(resultSet.getString("TenNSX"));
                hang.setQuocGia(resultSet.getString("QuocGia"));
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
