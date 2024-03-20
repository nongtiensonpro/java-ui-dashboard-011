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
import model.SanPhamModel;

/**
 *
 * @author Nong_Tien_Son
 */
public class SanPhamController {

    public boolean themSanPhamChiTietNew(SanPhamModel sanPhamNewInput) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            connection = DatabaseConnection.getConnection();
            StringBuilder cauLenhThemSQL = new StringBuilder("INSERT INTO [dbo].[ChiTietSanPham]\n"
                    + "           ([Ma_SanPhamChiTiet]\n"
                    + "           ,[MaSize]\n"
                    + "           ,[Ten]\n"
                    + "           ,[MaSanXuat]\n"
                    + "           ,[MaMauSac]\n"
                    + "           ,[MaHang]\n"
                    + "           ,[AnhSanPham]\n"
                    + "           ,[MaChatLieu]\n"
                    + "           ,[GiaNhap]\n"
                    + "           ,[GiaBan]\n"
                    + "           ,[SoLuong]\n"
                    + "           ,[TrangThai]\n"
                    + "           ,[NgayTao]\n"
                    + "           ,[NgaySua]\n"
                    + "           ,[MoTa])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)");
            statement = connection.prepareCall(cauLenhThemSQL.toString());
            statement.setString(1, sanPhamNewInput.getMa_SanPhamChiTiet());
            statement.setString(2, sanPhamNewInput.getMaSize());
            statement.setString(3, sanPhamNewInput.getTen());
            statement.setString(4, sanPhamNewInput.getMaSanXuat());
            statement.setString(5, sanPhamNewInput.getMaMauSac());
            statement.setString(6, sanPhamNewInput.getMaHang());
            statement.setBytes(7, sanPhamNewInput.getAnhSanPham());
            statement.setString(8, sanPhamNewInput.getMaChatLieu());
            statement.setDouble(9, sanPhamNewInput.getGiaNhap());
            statement.setDouble(10, sanPhamNewInput.getGiaBan());
            statement.setInt(11, sanPhamNewInput.getSoLuong());
            statement.setBoolean(12, sanPhamNewInput.isTrangThai());
            statement.setDate(13, sanPhamNewInput.getNgayTao());
            statement.setDate(14, sanPhamNewInput.getNgaySua());
            statement.setString(15, sanPhamNewInput.getMoTa());
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

    public List<SanPhamModel> getAllSanPhamChiTiet() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<SanPhamModel> sanPhamList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM [dbo].[ChiTietSanPham]";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SanPhamModel sanPhamNew = new SanPhamModel();
                sanPhamNew.setMa_SanPhamChiTiet(resultSet.getString("Ma_SanPhamChiTiet"));
                sanPhamNew.setMaSize(resultSet.getString("MaSize"));
                sanPhamNew.setTen(resultSet.getString("Ten"));
                sanPhamNew.setMaSanXuat(resultSet.getString("MaSanXuat"));
                sanPhamNew.setMaMauSac(resultSet.getString("MaMauSac"));
                sanPhamNew.setMaHang(resultSet.getString("MaHang"));
                sanPhamNew.setAnhSanPham(resultSet.getBytes("AnhSanPham"));
                sanPhamNew.setMaChatLieu(resultSet.getString("MaChatLieu"));
                sanPhamNew.setGiaNhap(resultSet.getDouble("GiaNhap"));
                sanPhamNew.setGiaBan(resultSet.getDouble("GiaBan"));
                sanPhamNew.setSoLuong(resultSet.getInt("SoLuong"));
                sanPhamNew.setTrangThai(resultSet.getBoolean("TrangThai"));
                sanPhamNew.setNgayTao(resultSet.getDate("NgayTao"));
                sanPhamNew.setNgaySua(resultSet.getDate("NgaySua"));
                sanPhamNew.setMoTa(resultSet.getString("MoTa"));
                sanPhamList.add(sanPhamNew);
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

        return sanPhamList;
    }

    public boolean updateSanPhamChiTiet(SanPhamModel sanPhamNewInput) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE [dbo].[ChiTietSanPham]\n"
                    + "SET [MaSize] = ?\n"
                    + "   ,[Ten] = ?\n"
                    + "   ,[MaSanXuat] = ?\n"
                    + "   ,[MaMauSac] = ?\n"
                    + "   ,[MaHang] = ?\n"
                    + "   ,[AnhSanPham] = ?\n"
                    + "   ,[MaChatLieu] = ?\n"
                    + "   ,[GiaNhap] = ?\n"
                    + "   ,[GiaBan] = ?\n"
                    + "   ,[SoLuong] = ?\n"
                    + "   ,[TrangThai] = ?\n"
                    + "   ,[NgaySua] = ?\n"
                    + "   ,[MoTa] = ?\n"
                    + "WHERE [Ma_SanPhamChiTiet] = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, sanPhamNewInput.getMaSize());
            statement.setString(2, sanPhamNewInput.getTen());
            statement.setString(3, sanPhamNewInput.getMaSanXuat());
            statement.setString(4, sanPhamNewInput.getMaMauSac());
            statement.setString(5, sanPhamNewInput.getMaHang());
            statement.setBytes(6, sanPhamNewInput.getAnhSanPham());
            statement.setString(7, sanPhamNewInput.getMaChatLieu());
            statement.setDouble(8, sanPhamNewInput.getGiaNhap());
            statement.setDouble(9, sanPhamNewInput.getGiaBan());
            statement.setInt(10, sanPhamNewInput.getSoLuong());
            statement.setBoolean(11, sanPhamNewInput.isTrangThai());
            statement.setDate(12, sanPhamNewInput.getNgaySua());
            statement.setString(13, sanPhamNewInput.getMoTa());
            statement.setString(14, sanPhamNewInput.getMa_SanPhamChiTiet());
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

    public List<SanPhamModel> timSanPhamChiTietGanDung(String maSanPhamChiTiet) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<SanPhamModel> danhSachSanPham = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            String cauLenhTimKiemSQL = "SELECT * FROM [dbo].[ChiTietSanPham] WHERE [Ma_SanPhamChiTiet] LIKE ? OR Ten Like ?";
            statement = connection.prepareStatement(cauLenhTimKiemSQL);
            statement.setString(1, "%" + maSanPhamChiTiet + "%");
            statement.setString(2,"%"+ maSanPhamChiTiet + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SanPhamModel sanPhamNew = new SanPhamModel();
                sanPhamNew.setMa_SanPhamChiTiet(resultSet.getString("Ma_SanPhamChiTiet"));
                sanPhamNew.setMaSize(resultSet.getString("MaSize"));
                sanPhamNew.setTen(resultSet.getString("Ten"));
                sanPhamNew.setMaSanXuat(resultSet.getString("MaSanXuat"));
                sanPhamNew.setMaMauSac(resultSet.getString("MaMauSac"));
                sanPhamNew.setMaHang(resultSet.getString("MaHang"));
                sanPhamNew.setAnhSanPham(resultSet.getBytes("AnhSanPham"));
                sanPhamNew.setMaChatLieu(resultSet.getString("MaChatLieu"));
                sanPhamNew.setGiaNhap(resultSet.getDouble("GiaNhap"));
                sanPhamNew.setGiaBan(resultSet.getDouble("GiaBan"));
                sanPhamNew.setSoLuong(resultSet.getInt("SoLuong"));
                sanPhamNew.setTrangThai(resultSet.getBoolean("TrangThai"));
                sanPhamNew.setNgayTao(resultSet.getDate("NgayTao"));
                sanPhamNew.setNgaySua(resultSet.getDate("NgaySua"));
                sanPhamNew.setMoTa(resultSet.getString("MoTa"));
                danhSachSanPham.add(sanPhamNew);
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

        return danhSachSanPham;
    }

    public boolean xoaSanPhamChiTiet(String maSanPham) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM [dbo].[ChiTietSanPham] WHERE Ma_SanPhamChiTiet = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maSanPham);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
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
