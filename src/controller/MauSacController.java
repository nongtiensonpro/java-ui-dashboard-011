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
import model.MauSacModel;

/**
 *
 * @author Khanh
 */
public class MauSacController {
    public List<MauSacModel> timkiemMauSac(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        MauSacModel mauSac = null;
        
        List<MauSacModel> danhsachMauSac = new ArrayList<>();
         try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from MauSac");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                mauSac = new MauSacModel();
                mauSac.setMaMauSac(resultSet.getString("MaMauSac"));
                mauSac.setTenMauSac(resultSet.getString("TenMauSac"));
                mauSac.setTrangThai(resultSet.getBoolean("TrangThai"));
                mauSac.setNgayTao(resultSet.getDate("NgayTao"));
                mauSac.setNgaySua(resultSet.getDate("NgaySua"));
                mauSac.setMoTa(resultSet.getString("MoTa"));
                danhsachMauSac.add(mauSac);
            }
            return danhsachMauSac;
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
    public Boolean themMauSac(MauSacModel mauSactruyenvao){
         Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
         try {
            connection = DatabaseConnection.getConnection();
            String caulenhthem = new String("INSERT INTO [dbo].[MauSac]\n"
                    + "           ([MaMauSac]\n"
                    + "           ,[TrangThai]\n"
                    + "           ,[NgayTao]\n"
                    + "           ,[NgaySua]\n"
                    + "           ,[MoTa],"
                    + "TenMauSac)\n"
                    + "     VALUES\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,"
                    + "?)");
            statement = connection.prepareStatement(caulenhthem);
            statement.setString(1, mauSactruyenvao.getMaMauSac());
            statement.setBoolean(2, mauSactruyenvao.getTrangThai());
            statement.setDate(3, mauSactruyenvao.getNgayTao());
            statement.setDate(4, mauSactruyenvao.getNgaySua());
            statement.setString(5, mauSactruyenvao.getMoTa());
            statement.setString(6, mauSactruyenvao.getTenMauSac());
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
    public Boolean suaMauSac(MauSacModel mauSacModel){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[MauSac]\n"
                    + "   SET \n"
                    + "      [TrangThai] = ?\n"
                    + "      ,[NgayTao] = ?\n"
                    + "      ,[NgaySua] = ?\n"
                    + "      ,[MoTa] = ?"
                    + "       ,TenMauSac = ?\n"
                    + " WHERE MaMauSac=?");
            statement = connection.prepareStatement(caulenhUpdate);
//             statement.setString(1, hangModel.getMaHang());
            statement.setBoolean(1, mauSacModel.getTrangThai());
            statement.setDate(2, mauSacModel.getNgayTao());
            statement.setDate(3, mauSacModel.getNgaySua());
            System.out.println(mauSacModel.getNgaySua() + "MeoMeo");
            statement.setString(4, mauSacModel.getMoTa());
            statement.setString(5, mauSacModel.getTenMauSac());
            statement.setString(6, mauSacModel.getMaMauSac());
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
    
    public List<MauSacModel> timKiemMauSacTheoMa(String matimkiem){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        MauSacModel mauSac = null;
        
        List<MauSacModel> danhsachMauSac = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from MauSac where MaMauSac like ?");
             statement = connection.prepareStatement(caulenhtruyvan);
             statement.setString(1,matimkiem );
             resultSet = statement.executeQuery();
             while(resultSet.next()){
                 mauSac = new MauSacModel();
                 mauSac.setMaMauSac(resultSet.getString("MaMauSac"));
                 mauSac.setTenMauSac(resultSet.getString("TenMauSac"));
                 mauSac.setTrangThai(resultSet.getBoolean("TrangThai"));
                 mauSac.setNgayTao(resultSet.getDate("NgayTao"));
                 mauSac.setNgaySua(resultSet.getDate("NgaySua"));
                 mauSac.setMoTa(resultSet.getString("MoTa"));
                 danhsachMauSac.add(mauSac);
             }
             return danhsachMauSac;
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
