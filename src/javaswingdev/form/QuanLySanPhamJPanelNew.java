/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaswingdev.form;

import javaswingdev.card.ModelCard;
import controller.ChatLieuController;
import controller.HangController;
import controller.MauSacController;
import controller.NhaSanXuatController;
import controller.SanPhamController;
import controller.SizeController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import static javaswingdev.form.DangNhap.Ma_NhanVienstatic;
import static javaswingdev.main.MainTaoFrom.taiKhoanNhanVienControllerStatic;
import javaswingdev.menu.ModelMenuItem;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.ChatLieuModel;
import model.HangModel;
import model.MauSacModel;
import model.NhaSanXuatModel;
import model.SanPhamModel;
import model.SizeModel;
import model.TaiKhoanNhanVIenFull;
import utilities.MsgBox;
import view_2.ChatLieu;
import view_2.MauSac;
import view_2.NSX;
import view_2.Size;
import view_2.ThemChatLieu;
import view_2.ThemHang;
import view_2.ThemMauSac;
import view_2.ThemNSX;
import view_2.ThemSize;

/**
 *
 * @author Nong_Tien_Son
 */
public class QuanLySanPhamJPanelNew extends javax.swing.JPanel {

    HangController hangController = new HangController();
    MauSacController mauSacController = new MauSacController();
    NhaSanXuatController nhaSanXuatController = new NhaSanXuatController();
    ChatLieuController chatLieuController = new ChatLieuController();
    SizeController sizeController = new SizeController();
    SanPhamController sanPhamController = new SanPhamController();
    List<SanPhamModel> listSanPhamNew = sanPhamController.getAllSanPhamChiTiet();
    byte[] imageBytes;

    /**
     * Creates new form NewJPanel
     */
    public QuanLySanPhamJPanelNew() {
        initComponents();
        loadComboBoxNew();
        hienThiLenTable();

    }

    private void loadComboBoxNew() {

        java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
        txtNgayTao.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));

        rdoHoatDong.setSelected(true);

        DefaultComboBoxModel dcm = new DefaultComboBoxModel();

        if (hangController.timkiemHang().size() > 0) {
            dcm = (DefaultComboBoxModel) cboLoaiHang.getModel();
            cboLoaiHang.removeAllItems();
            List<HangModel> listLoaiHang = hangController.timkiemHang();
            for (HangModel hangModel : listLoaiHang) {
                dcm.addElement(hangModel.getMaHang() + " " + hangModel.getTenHang());
            }
        }

        if (mauSacController.timkiemMauSac().size() > 0) {
            dcm = (DefaultComboBoxModel) cboMauSac.getModel();
            cboMauSac.removeAllItems();
            List<MauSacModel> listMauSac = mauSacController.timkiemMauSac();
            for (MauSacModel mauSacModel : listMauSac) {
                dcm.addElement(mauSacModel.getTenMauSac());
            }
        }

        if (nhaSanXuatController.timkiemNSX().size() > 0) {
            dcm = (DefaultComboBoxModel) cboNhaSanXuat.getModel();
            cboNhaSanXuat.removeAllItems();
            List<NhaSanXuatModel> listNhaSanXuat = nhaSanXuatController.timkiemNSX();
            for (NhaSanXuatModel nhaSanXuatModel : listNhaSanXuat) {
                dcm.addElement(nhaSanXuatModel.getMaNSX() + " " + nhaSanXuatModel.getTenNSX());
            }
        }

        if (chatLieuController.timkiemChatLieu().size() > 0) {
            dcm = (DefaultComboBoxModel) cboMaChatLieu.getModel();
            cboMaChatLieu.removeAllItems();
            List<ChatLieuModel> listChatLieu = chatLieuController.timkiemChatLieu();
            for (ChatLieuModel chatLieuModel : listChatLieu) {
                dcm.addElement(chatLieuModel.getMaChatLieu() + " " + chatLieuModel.getTen());
            }
        }

        if (sizeController.timkiemSize().size() > 0) {
            dcm = (DefaultComboBoxModel) cboMaSize.getModel();
            cboMaSize.removeAllItems();
            List<SizeModel> listSizeModel = sizeController.timkiemSize();
            for (SizeModel sizeModel : listSizeModel) {
                dcm.addElement(sizeModel.getMaSize() + " " + sizeModel.getSoSize());
            }
        }
    }

    private void hienThiLenTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblBangSanPham.getModel();
        dtm.setRowCount(0);
        if (sanPhamController.getAllSanPhamChiTiet().size() > 0) {

            for (SanPhamModel s : listSanPhamNew) {
                dtm.addRow(new Object[]{
                    s.getMa_SanPhamChiTiet(),
                    s.getTen(),
                    hangController.timKiemHangTheoMa(s.getMaHang()).get(0).getTenHang(),
                    nhaSanXuatController.timKiemNSXTheoMa(s.getMaSanXuat()).get(0).getTenNSX(),
                    mauSacController.timKiemMauSacTheoMa(s.getMaMauSac()).get(0).getTenMauSac(),
                    chatLieuController.timKiemChatLieuTheoMa(s.getMaChatLieu()).getTen(),
                    s.getGiaNhap(),
                    s.getGiaBan(),
                    s.getNgayTao(),
                    sizeController.timKiemSizeTheoMa(s.getMaSize()).getSoSize(),
                    s.getMoTa(),
                    s.isTrangThai() ? "Hoạt động" : "Không hoạt động"
                });
            }
        }
    }

    private boolean kiemTraTextField() {

        if (txtMaSanPham.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập mã sản phẩm !");
            return false;
        }

        if (txtTenSanPham.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập tên sản phẩm");
            return false;
        }

        if (txtGiaNhap.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập giá nhập");
            return false;
        }

        try {
            Double giaNhap = Double.valueOf(txtGiaNhap.getText());
        } catch (Exception e) {
            MsgBox.alert(this, "Bạn cần nhập giá nhập là số !");
        }

        Double giaNhap = Double.valueOf(txtGiaNhap.getText());
        if (giaNhap <= 0) {
            MsgBox.alert(this, "Bạn cần nhập giá nhập lớn hơn 0");
            return false;
        }

        if (txtGiaBan.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập giá bán");
            return false;
        }

        try {
            Double giaBan = Double.valueOf(txtGiaBan.getText());
        } catch (Exception e) {
            MsgBox.alert(this, "Bạn cần nhập giá bán là số !");
        }
        Double giaBan = Double.valueOf(txtGiaBan.getText());
        if (giaBan <= 0) {
            MsgBox.alert(this, "Bạn cần nhập giá bán lớn hơn 0");
            return false;
        }

        if (txtSoLuong.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập số lượng !");
            return false;
        }

        try {
            Integer soLuong = Integer.valueOf(txtSoLuong.getText());
        } catch (Exception e) {
            MsgBox.alert(this, "Bạn cần nhập số lượng là số nguyên");
            return false;
        }

        Integer soLuong = Integer.valueOf(txtSoLuong.getText());
        if (soLuong <= 0) {
            MsgBox.alert(this, "Bạn cần nhập số lượng lớn hơn 0");
            return false;
        }
        if (txtMoTa.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập mô tả !");
            return false;
        }
        
        if(txtAnh.getIcon()==null){
            MsgBox.alert(this, "Bạn cần chọn ảnh !");
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtTenSanPham = new javax.swing.JTextField();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboMaChatLieu = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cboLoaiHang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboNhaSanXuat = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cboMaSize = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtAnh = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        rdoKhongHoatDong = new javax.swing.JRadioButton();
        rdoHoatDong = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBangSanPham = new javaswingdev.swing.table.Table();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(625, 625, 625))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Mã sản phẩm");

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Màu sắc");

        cboMaChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã chất liệu");

        jLabel10.setText("Giá nhập");

        jLabel11.setText("Giá bán");

        jLabel12.setText("Ngày tạo");

        jLabel14.setText("Số lượng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaNhap)
                    .addComponent(txtGiaBan)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSoLuong))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jButton8.setText("0");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("0");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMauSac, 0, 231, Short.MAX_VALUE)
                            .addComponent(cboMaChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cboLoaiHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiHangActionPerformed(evt);
            }
        });

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Loại hãng");

        cboNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNhaSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhaSanXuatActionPerformed(evt);
            }
        });

        jLabel8.setText("Nhà sản xuất");

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cboMaSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã size");

        txtAnh.setBackground(new java.awt.Color(255, 255, 255));
        txtAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAnhMouseClicked(evt);
            }
        });

        jButton6.setText("0");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("0");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(cboLoaiHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboMaSize, 0, 289, Short.MAX_VALUE)
                                    .addComponent(cboNhaSanXuat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(3, 3, 3)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addGap(2, 2, 2)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jLabel15.setText("Mô tả");

        buttonGroup1.add(rdoKhongHoatDong);
        rdoKhongHoatDong.setText("Không hoạt động");
        rdoKhongHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKhongHoatDongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setText("Hoạt động");

        jLabel13.setText("Trạng thái");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoi))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoHoatDong)
                            .addComponent(rdoKhongHoatDong)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(370, 370, 370)
                                .addComponent(jLabel13)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rdoHoatDong)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoKhongHoatDong)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnLamMoi))
                        .addGap(20, 20, 20))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblBangSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại hãng", "Nhà sản xuất", "Màu sắc", "Mã chất liệu", "Giá nhập", "Giá bán", "Ngày tạo", "Mã size", "Mô tả", "Trạng thái"
            }
        ));
        tblBangSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBangSanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboNhaSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhaSanXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNhaSanXuatActionPerformed

    private void rdoKhongHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKhongHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKhongHoatDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (kiemTraTextField()) {
            boolean ketQua = sanPhamController.themSanPhamChiTietNew(sanPhamMoiTuText());
            if (ketQua) {
                MsgBox.alert(this, "Bạn đã thêm sản phẩm thành công !");
                listSanPhamNew = sanPhamController.getAllSanPhamChiTiet();
                hienThiLenTable();

            } else {
                MsgBox.alert(this, "Bạn đã thêm sản phẩm thất bại !");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ThemHang themHang = new ThemHang();
        themHang.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoiTextField();

    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void lamMoiTextField() {
        // TODO add your handling code here:
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        txtSoLuong.setText("");
        txtMoTa.setText("");
        txtTimKiem.setText("");
        java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
        txtNgayTao.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
        listSanPhamNew = sanPhamController.getAllSanPhamChiTiet();
        txtAnh.setIcon(null);
        hienThiLenTable();
        loadComboBoxNew();
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ThemMauSac themMauSac = new ThemMauSac();
        themMauSac.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ThemChatLieu themChatLieu = new ThemChatLieu();
        themChatLieu.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ThemNSX themNSX = new ThemNSX();
        themNSX.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ThemSize themSize = new ThemSize();
        themSize.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnhMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy tệp ảnh được chọn
            File selectedFile = fileChooser.getSelectedFile();

            // Hiển thị ảnh
            try {
                ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                Image image = icon.getImage();
                Image resizedImage = image.getScaledInstance(txtAnh.getWidth(), txtAnh.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(resizedImage);
                txtAnh.setIcon(icon);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi tải ảnh: " + e.getMessage());
            }

            // Chuyển đổi ảnh sang byte array
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", baos);
                imageBytes = baos.toByteArray();
                baos.close();
                System.out.println("Do dai anh meo meo ne" + imageBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi chuyển đổi ảnh: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtAnhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (tblBangSanPham.getSelectedRow() > -1) {

            boolean luaChon = MsgBox.confirm(this, "Bạn có muốn cập nhật không");
            if (luaChon) {
                if (kiemTraTextField()) {
                    boolean ketQua = sanPhamController.updateSanPhamChiTiet(sanPhamMoiTuText());
                    if (ketQua) {
                        MsgBox.alert(this, "Bạn đã cập nhật thành công");
                        listSanPhamNew = sanPhamController.getAllSanPhamChiTiet();
                        hienThiLenTable();
                    } else {
                        MsgBox.alert(this, "Bạn đã cập nhật thất bại");
                    }
                }
            }

        } else {
            MsgBox.alert(this, "Bạn cần chọn dòng cần sửa");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (tblBangSanPham.getSelectedRow() > -1) {

            boolean luaChon = MsgBox.confirm(this, "Bạn có muốn xóa sản phẩm không");
            if (luaChon) {
                if (kiemTraTextField()) {
                    boolean ketQua = sanPhamController.xoaSanPhamChiTiet(txtMaSanPham.getText());
                    if (ketQua) {
                        MsgBox.alert(this, "Bạn đã xóa sản phẩm thành công");
                        lamMoiTextField();
                        hienThiLenTable();
                    } else {
                        MsgBox.alert(this, "Bạn đã xóa sản phẩm thất bại");
                    }
                }
            }

        } else {
            MsgBox.alert(this, "Bạn cần chọn dòng cần sửa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        if (txtTimKiem.getText().trim().equals("")) {
            listSanPhamNew = sanPhamController.getAllSanPhamChiTiet();
            hienThiLenTable();
        } else {
            listSanPhamNew = sanPhamController.timSanPhamChiTietGanDung(txtTimKiem.getText());
            hienThiLenTable();
        }

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblBangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangSanPhamMouseClicked
        // TODO add your handling code here:
        if (tblBangSanPham.getSelectedRow() > -1) {
            SanPhamModel sanPhamModel = sanPhamController.getAllSanPhamChiTiet().get(tblBangSanPham.getSelectedRow());
            txtMaSanPham.setText(sanPhamModel.getMa_SanPhamChiTiet());
            txtTenSanPham.setText(sanPhamModel.getTen());
            txtGiaBan.setText(String.valueOf(sanPhamModel.getGiaBan()));
            txtGiaNhap.setText(String.valueOf(sanPhamModel.getGiaNhap()));
            cboMauSac.setSelectedItem(mauSacController.timKiemMauSacTheoMa(sanPhamModel.getMaMauSac()).get(0).getTenMauSac());
            cboLoaiHang.setSelectedItem(sanPhamModel.getMaHang() + " " + hangController.timKiemHangTheoMa(sanPhamModel.getMaHang()).get(0).getTenHang());
            cboNhaSanXuat.setSelectedItem(sanPhamModel.getMaSanXuat() + " " + nhaSanXuatController.timKiemNSXTheoMa(sanPhamModel.getMaSanXuat()).get(0).getTenNSX());
            cboMaChatLieu.setSelectedItem(sanPhamModel.getMaChatLieu() + " " + chatLieuController.timKiemChatLieuTheoMa(sanPhamModel.getMaChatLieu()).getTen());
            cboMaSize.setSelectedItem(sanPhamModel.getMaSize() + " " + sizeController.timKiemSizeTheoMa(sanPhamModel.getMaSize()).getSoSize());
            txtNgayTao.setDate(sanPhamModel.getNgayTao());
            txtSoLuong.setText(String.valueOf(sanPhamModel.getSoLuong()));
            txtMoTa.setText(sanPhamModel.getMoTa());
            if (sanPhamModel.isTrangThai()) {
                rdoHoatDong.setSelected(true);
            } else {
                rdoKhongHoatDong.setSelected(true);
            }

            imageBytes = sanPhamModel.getAnhSanPham();

            ImageIcon icon = new ImageIcon(imageBytes);
            Image scaledImage = icon.getImage().getScaledInstance(345, 216, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            txtAnh.setIcon(icon);

        }
    }//GEN-LAST:event_tblBangSanPhamMouseClicked

    private void cboLoaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLoaiHangActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        NSX nsx = new NSX();
        nsx.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Size size = new Size();
        size.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        MauSac mauSac = new MauSac();
        mauSac.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed
    private SanPhamModel sanPhamMoiTuText() {
        SanPhamModel spm = new SanPhamModel();
        spm.setMa_SanPhamChiTiet(txtMaSanPham.getText());
        spm.setTen(txtTenSanPham.getText());
        spm.setGiaNhap(Double.valueOf(txtGiaNhap.getText()));
        spm.setGiaBan(Double.valueOf(txtGiaBan.getText()));
        spm.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        spm.setMaHang(hangController.timkiemHang().get(cboLoaiHang.getSelectedIndex()).getMaHang());
        spm.setMaMauSac(mauSacController.timkiemMauSac().get(cboMauSac.getSelectedIndex()).getMaMauSac());
        spm.setMaSanXuat(nhaSanXuatController.timkiemNSX().get(cboNhaSanXuat.getSelectedIndex()).getMaNSX());
        spm.setMaChatLieu(chatLieuController.timkiemChatLieu().get(cboNhaSanXuat.getSelectedIndex()).getMaChatLieu());
        spm.setMaSize(sizeController.timkiemSize().get(cboMaSize.getSelectedIndex()).getMaSize());
        spm.setTrangThai(rdoHoatDong.isSelected());
        spm.setMoTa(txtMoTa.getText());
        java.util.Date ngaySuaDate = txtNgayTao.getCalendar().getTime();
        java.sql.Date ngaySuaSQL = new java.sql.Date(ngaySuaDate.getTime());
        spm.setNgayTao(ngaySuaSQL);
        spm.setNgaySua(ngaySuaSQL);
        spm.setAnhSanPham(imageBytes);
        return spm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoaiHang;
    private javax.swing.JComboBox<String> cboMaChatLieu;
    private javax.swing.JComboBox<String> cboMaSize;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNhaSanXuat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhongHoatDong;
    private javaswingdev.swing.table.Table tblBangSanPham;
    private javax.swing.JLabel txtAnh;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
