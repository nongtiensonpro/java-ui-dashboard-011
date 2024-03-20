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
import model.ChatLieuModel;

/**
 *
 * @author LENHATLINH
 */
public class ChatLieuController {

    public List<ChatLieuModel> timkiemChatLieu() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ChatLieuModel cl = null;

        List<ChatLieuModel> danhsachChatLieu = new ArrayList<>();
        try {
            connection = DatabaseConnection.getConnection();
            String caulenhtruyvan = new String("select * from ChatLieu");
            statement = connection.prepareStatement(caulenhtruyvan);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cl = new ChatLieuModel();
                cl.setMaChatLieu(resultSet.getString("MaChatLieu"));
                cl.setTen(resultSet.getString("Ten"));
                cl.setMoTa(resultSet.getString("MoTa"));
                cl.setNgayTao(resultSet.getDate("NgayTao"));
                cl.setNgaySua(resultSet.getDate("NgaySua"));
                cl.setTrangThai(resultSet.getBoolean("TrangThai"));
                danhsachChatLieu.add(cl);
            }
            return danhsachChatLieu;
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

    public Boolean themChatLieu(ChatLieuModel chatLieutruyenvao) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhthem = new String("INSERT INTO [dbo].[ChatLieu]\n"
                    + "           ([MaChatLieu]\n"
                    + "           ,[Ten]\n"
                    + "           ,[MoTa]\n"
                    + "           ,[NgayTao]\n"
                    + "           ,[NgaySua]\n"
                    + "           ,[TrangThai])\n"
                    + "     VALUES\n"
                    + "           (?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?,\n"
                    + "           ?)");
            statement = connection.prepareStatement(caulenhthem);
            statement.setString(1, chatLieutruyenvao.getMaChatLieu());
            statement.setString(2, chatLieutruyenvao.getTen());
            statement.setString(3, chatLieutruyenvao.getMoTa());
            statement.setDate(4, chatLieutruyenvao.getNgayTao());
            statement.setDate(5, chatLieutruyenvao.getNgaySua());
            statement.setBoolean(6, chatLieutruyenvao.getTrangThai());
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

    public Boolean suaTenChatLieu(ChatLieuModel clModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String caulenhUpdate = new String("UPDATE [dbo].[ChatLieu]\n"
                    + "   SET \n"
                    + "      [Ten]=?\n"
                    + "      ,[MoTa]=?\n"
                    + "      ,[NgayTao]=?\n"
                    + "      ,[NgaySua]=?\n"
                    + "      ,[TrangThai]=?\n"
                    + "      WHERE[MaChatLieu] =?"
            );
            statement = connection.prepareStatement(caulenhUpdate);
            statement.setString(1, clModel.getMaChatLieu());
            statement.setString(2, clModel.getTen());
            statement.setString(3, clModel.getMoTa());
            statement.setDate(4, clModel.getNgayTao());
            statement.setDate(5, clModel.getNgaySua());
            statement.setBoolean(6, clModel.getTrangThai());
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

    public ChatLieuModel timKiemChatLieuTheoMa(String maChatLieu) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ChatLieuModel chatLieuTimThay = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM [dbo].[ChatLieu] WHERE [MaChatLieu] = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maChatLieu);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                chatLieuTimThay = new ChatLieuModel();
                chatLieuTimThay.setMaChatLieu(resultSet.getString("MaChatLieu"));
                chatLieuTimThay.setTen(resultSet.getString("Ten"));
                chatLieuTimThay.setMoTa(resultSet.getString("MoTa"));
                chatLieuTimThay.setNgayTao(resultSet.getDate("NgayTao"));
                chatLieuTimThay.setNgaySua(resultSet.getDate("NgaySua"));
                chatLieuTimThay.setTrangThai(resultSet.getBoolean("TrangThai"));
            }

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

        return chatLieuTimThay;
    }

}
