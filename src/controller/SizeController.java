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
import model.SizeModel;

/**
 *
 * @author LENHATLINH
 */
public class SizeController {

    public List<SizeModel> timkiemSize() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SizeModel s = null;

        List<SizeModel> danhsachTenSize = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from Size");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                s = new SizeModel();
                s.setMaSize(resultSet.getString("MaSize"));
                s.setSoSize(resultSet.getInt("SoSize"));
                s.setMoTa(resultSet.getString("MoTa"));
                danhsachTenSize.add(s);
            }
            return danhsachTenSize;
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

    public Boolean themTenSize(SizeModel sanPhamtruyenvao) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhthem = new String("INSERT INTO [dbo].[Size]\n"
                    + "           ([MaSize]\n"
                    + "           ,[SoSize]\n"
                    + "           ,[MoTa])\n"
                    + "     VALUES\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?)");
            statement = connection.prepareStatement(caulenhthem);
            statement.setString(1, sanPhamtruyenvao.getMaSize());
            statement.setInt(2, sanPhamtruyenvao.getSoSize());
            statement.setString(3, sanPhamtruyenvao.getMoTa());
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

    public Boolean suaTenSize(SizeModel sModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[Size]\n"
                    + "   SET \n"
                    + "      [SoSize]=?\n"
                    + "      ,[MoTa]=?\n"
                    + "      WHERE [MaSize] = ?"
            );
            statement = connection.prepareStatement(caulenhUpdate);
//             statement.setString(1, sModel.getMaHang());
            statement.setString(3, sModel.getMaSize());
            statement.setInt(1, sModel.getSoSize());
            statement.setString(2, sModel.getMoTa());
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

    public SizeModel timKiemSizeTheoMa(String maSize) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SizeModel sizeTimThay = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM [dbo].[Size] WHERE [MaSize] = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maSize);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                sizeTimThay = new SizeModel();
                sizeTimThay.setMaSize(resultSet.getString("MaSize"));
                sizeTimThay.setSoSize(resultSet.getInt("SoSize"));
                sizeTimThay.setMoTa(resultSet.getString("MoTa"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return sizeTimThay;
    }

}
