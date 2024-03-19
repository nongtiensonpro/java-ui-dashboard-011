/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view_main;

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
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.ChatLieuModel;
import model.HangModel;
import model.MauSacModel;
import model.NhaSanXuatModel;
import model.SanPhamModel;
import model.SizeModel;
import utilities.MsgBox;
import static view_main.DanhSachSanPham.sanPhamNewStatic;

/**
 *
 * @author Nong_Tien_Son
 */
public class SuaSanPhamJFrame extends javax.swing.JFrame {

    static byte[] imageBytes = null;
    HangController hangController = new HangController();
    MauSacController mauSacController = new MauSacController();
    NhaSanXuatController nhaSanXuatController = new NhaSanXuatController();
    SizeController sizeController = new SizeController();
    ChatLieuController chatLieuController = new ChatLieuController();
    SanPhamController sanPhamChiTietController = new SanPhamController();

    /**
     * Creates new form SanPhamJFrame
     */
    public SuaSanPhamJFrame() {
        initComponents();
        hienThiComBoBox();
        hienThiNgaySua();
        luaChonBanDau();
        hienThiSanPham();
    }

    private void luaChonBanDau() {
        rdoHoatDong.setSelected(true);
    }

    private boolean validateNew() {

        if (txtMaSanPham.getText().trim().toString().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập mã sản phẩm !");
            return false;
        }

        if (txtTenSanPham.getText().trim().toString().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập tên sản phẩm !");
            return false;
        }

        if (txtGiaNhap.getText().trim().equals("")) {
            try {
                Double giaNhap = Double.valueOf(txtGiaNhap.getText());

            } catch (Exception e) {
                MsgBox.alert(this, "Bạn cần nhập giá nhập là số và không được bỏ trống");
                return false;
            }
            MsgBox.alert(this, "Bạn cần nhập giá nhập là số và không được bỏ trống");
            return false;
        }

        if (txtGiaBan.getText().trim().equals("")) {
            try {
                Double giaBan = Double.valueOf(txtGiaBan.getText());
            } catch (Exception e) {
                MsgBox.alert(this, "Bạn cần nhập giá bán là số và không được bỏ trống");
                return false;
            }
            MsgBox.alert(this, "Bạn cần nhập giá bán là số và không được bỏ trống");
            return false;
        }
        if (txtSoLuong.getText().trim().equals("")) {
            try {
                Double soLuong = Double.valueOf(txtSoLuong.getText());
            } catch (Exception e) {
                MsgBox.alert(this, "Bạn cần nhập số lượng là số và không được bỏ trống");
                return false;
            }
            MsgBox.alert(this, "Bạn cần nhập giá số lượng là số và không được bỏ trống");
            return false;
        }
//        if (labelImage.getToolTipText()==null) {
//            MsgBox.alert(this, "Bạn cần chọn 1 ảnh !");
//            return false;
//        }
        return true;
    }

    private void hienThiComBoBox() {
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();

        if (hangController.timkiemHang().size() > -1) {
            boxModel = (DefaultComboBoxModel) cboHang.getModel();

            boxModel.removeAllElements();

            List<HangModel> danhSachHang = hangController.timkiemHang();
            int khaDung = 0;
            int khongKhaDung = 0;
            for (HangModel hangModel : danhSachHang) {
                if (hangModel.getTrangThai()) {
                    khaDung++;
                } else {
                    khongKhaDung++;
                }
                boxModel.addElement(hangModel.getMaHang() + " " + hangModel.getTenHang());
            }
            txtHangKhaDung.setText(String.valueOf(khaDung));
            txtHangKhongKhaDung.setText(String.valueOf(khongKhaDung));
        }

        if (nhaSanXuatController.timkiemNSX().size() > -1) {
            boxModel = (DefaultComboBoxModel) cboNhaSanXuat.getModel();

            boxModel.removeAllElements();

            List<NhaSanXuatModel> listNhaSanXuat = nhaSanXuatController.timkiemNSX();
            int khaDung = 0;
            int khongKhaDung = 0;
            for (NhaSanXuatModel nhaSanXuatModel : listNhaSanXuat) {
                if (nhaSanXuatModel.getTrangThai()) {
                    khaDung++;
                } else {
                    khongKhaDung++;
                }
                boxModel.addElement(nhaSanXuatModel.getMaNSX() + " " + nhaSanXuatModel.getTenNSX() + " " + nhaSanXuatModel.getQuocGia());
                txtNSXKhaDung.setText(String.valueOf(khaDung));
                txtNSXKhongKhaDung.setText(String.valueOf(khongKhaDung));
            }
        }

        if (mauSacController.timkiemMauSac().size() > -1) {
            boxModel = (DefaultComboBoxModel) cboMauSac.getModel();

            boxModel.removeAllElements();

            List<MauSacModel> listMauSac = mauSacController.timkiemMauSac();
            int khaDung = 0;
            int khongKhaDung = 0;
            for (MauSacModel mauSacModel : listMauSac) {
                if (mauSacModel.getTrangThai()) {
                    khaDung++;
                } else {
                    khongKhaDung++;
                }
                boxModel.addElement(mauSacModel.getMaMauSac() + " " + mauSacModel.getTenMauSac());
            }
            txtMauSacKhaDung.setText(String.valueOf(khaDung));
            txtMauSacKhongKhaDung.setText(String.valueOf(khongKhaDung));
        }

        if (sizeController.timkiemSize().size() > -1) {
            boxModel = (DefaultComboBoxModel) cboMaSize.getModel();

            boxModel.removeAllElements();

            List<SizeModel> listMaSize = sizeController.timkiemSize();
            int khaDung = 0;
            int khongKhaDung = 0;
            for (SizeModel sizeModel : listMaSize) {
                boxModel.addElement(sizeModel.getMaSize() + " " + sizeModel.getMoTa());

            }

        }

        if (chatLieuController.timkiemChatLieu().size() > -1) {
            boxModel = (DefaultComboBoxModel) cboChatLieu.getModel();
            boxModel.removeAllElements();
            List<ChatLieuModel> listChatLieu = chatLieuController.timkiemChatLieu();
            int khaDung = 0;
            int khongKhaDung = 0;
            for (ChatLieuModel chatLieuModel : listChatLieu) {
                if (chatLieuModel.getTrangThai()) {
                    khaDung++;
                } else {
                    khongKhaDung++;
                }
                 boxModel.addElement(chatLieuModel.getMaChatLieu() + " " + chatLieuModel.getTen());
            }
            txtChatLieuKhaDung.setText(String.valueOf(khaDung));
            txtChatLieuKhongKhaDung.setText(String.valueOf(khongKhaDung));
        }

    }

    private void hienThiNgayTao() {
        java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
        txtNgayTao.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
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
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboMaSize = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboNhaSanXuat = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        meomeo = new javax.swing.JLabel();
        cboHang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboChatLieu = new javax.swing.JComboBox<>();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoKhongHoatDong = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtHangKhaDung = new javax.swing.JLabel();
        txtHangKhongKhaDung = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNSXKhaDung = new javax.swing.JLabel();
        txtNSXKhongKhaDung = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMauSacKhaDung = new javax.swing.JLabel();
        txtMauSacKhongKhaDung = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtChatLieuKhaDung = new javax.swing.JLabel();
        txtChatLieuKhongKhaDung = new javax.swing.JLabel();
        txtAnh1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtNgaySua = new com.toedter.calendar.JDateChooser();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel20.setText("SỬA SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnSua)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSanPhamActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên sản phẩm");

        cboMaSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Mã Size");

        jLabel3.setText("Nhà Sản Xuất");

        cboNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Màu sắc");

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        meomeo.setText("Loại Hàng");

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Mã Chất Liệu");

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });

        jLabel7.setText("Giá Nhập");

        jLabel8.setText("Giá Bán");

        jLabel9.setText("Số Lượng");

        jLabel10.setText("Trang Thái");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jLabel11.setText("Mô Tả");

        jLabel12.setText("Mã Sản Phẩm");

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setText("Hoạt động");

        buttonGroup1.add(rdoKhongHoatDong);
        rdoKhongHoatDong.setText("Không hoạt động");

        jLabel13.setText("Khả dụng");

        jLabel14.setText("Không khả dụng");

        txtHangKhaDung.setText("0");

        txtHangKhongKhaDung.setText("0");

        jLabel5.setText("Khả dụng");

        jLabel15.setText("Không khả dụng");

        txtNSXKhaDung.setText("0");

        txtNSXKhongKhaDung.setText("0");

        jLabel16.setText("Khả dụng");

        txtMauSacKhaDung.setText("0");

        txtMauSacKhongKhaDung.setText("0");

        jLabel18.setText("Ngày Tạo");

        jLabel21.setText("Không khả dụng");

        jLabel17.setText("Khả dụng");

        jLabel19.setText("Không khả dụng");

        txtChatLieuKhaDung.setText("0");

        txtChatLieuKhongKhaDung.setText("0");

        txtAnh1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Chọn ảnh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel22.setText("Ngày Sửa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(meomeo)
                                    .addComponent(jLabel9)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(txtMaSanPham))
                                .addComponent(jLabel12)
                                .addComponent(cboHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNSXKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNSXKhongKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMauSacKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMauSacKhongKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdoHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoKhongHoatDong))
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtChatLieuKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChatLieuKhongKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHangKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtHangKhongKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel8)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNgaySua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboMaSize, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meomeo)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtHangKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtHangKhongKhaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtMauSacKhaDung)
                            .addComponent(jLabel21)
                            .addComponent(txtMauSacKhongKhaDung)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoHoatDong)
                                .addComponent(rdoKhongHoatDong))
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtChatLieuKhaDung)
                                    .addComponent(jLabel15)
                                    .addComponent(txtChatLieuKhongKhaDung)
                                    .addComponent(jLabel5)
                                    .addComponent(txtNSXKhaDung)
                                    .addComponent(jLabel19)
                                    .addComponent(txtNSXKhongKhaDung))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(cboMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))))
                            .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    private void txtTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSanPhamActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // Mở hộp thoại chọn ảnh
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
                Image resizedImage = image.getScaledInstance(txtAnh1.getWidth(), txtAnh1.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(resizedImage);
                txtAnh1.setIcon(icon);
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (validateNew()) {
            boolean ketQua = sanPhamChiTietController.updateSanPhamChiTiet(taoObjectSanPhamNew());
            if (ketQua) {
                MsgBox.alert(this, "Bạn đã sửa sản phẩm thành công !");
            } else {
                MsgBox.alert(this, "Bạn đã sửa sản phẩm thất bại !");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SuaSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SuaSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SuaSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SuaSanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SuaSanPhamJFrame().setVisible(true);
//            }
//        });
//    }

    private SanPhamModel taoObjectSanPhamNew() {
        SanPhamModel sanPhamNew1 = new SanPhamModel();
        sanPhamNew1.setMa_SanPhamChiTiet(txtMaSanPham.getText());
        sanPhamNew1.setTen(txtTenSanPham.getText());
        sanPhamNew1.setGiaNhap(Double.valueOf(txtGiaNhap.getText()));
        sanPhamNew1.setGiaBan(Double.valueOf(txtGiaBan.getText()));
        sanPhamNew1.setMaMauSac(mauSacController.timkiemMauSac().get(cboMauSac.getSelectedIndex()).getMaMauSac());
        sanPhamNew1.setMaHang(hangController.timkiemHang().get(cboHang.getSelectedIndex()).getMaHang());
        sanPhamNew1.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sanPhamNew1.setTrangThai(rdoHoatDong.isSelected());
        java.util.Date utilDate = txtNgayTao.getCalendar().getTime();
        java.sql.Date ngayTao = new java.sql.Date(utilDate.getTime());
//        sanPhamNew1.setNgayTao(ngayTao);
        sanPhamNew1.setNgaySua(ngayTao);
        sanPhamNew1.setMaSanXuat(nhaSanXuatController.timkiemNSX().get(cboNhaSanXuat.getSelectedIndex()).getMaNSX());
        sanPhamNew1.setMaChatLieu(chatLieuController.timkiemChatLieu().get(cboChatLieu.getSelectedIndex()).getMaChatLieu());
        sanPhamNew1.setMaSize(sizeController.timkiemSize().get(cboMaSize.getSelectedIndex()).getMaSize());
        if (txtMoTa.getText().equals("") == false) {
            sanPhamNew1.setMoTa(txtMoTa.getText());
        } else {
            sanPhamNew1.setMoTa("Thông tin đang cập nhật !");
        }
        sanPhamNew1.setAnhSanPham(imageBytes);
        System.out.println(cboMaSize.getItemCount() + "Huhuhuhuhuhuh");;
        return sanPhamNew1;
    }

    private void hienThiSanPham() {
        txtMaSanPham.setText(sanPhamNewStatic.getMa_SanPhamChiTiet());
        txtTenSanPham.setText(sanPhamNewStatic.getTen());
        txtGiaNhap.setText(String.valueOf(sanPhamNewStatic.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(sanPhamNewStatic.getGiaBan()));
        cboMauSac.setSelectedItem(sanPhamNewStatic.getMaMauSac() + " " + mauSacController.timKiemMauSacTheoMa(sanPhamNewStatic.getMaMauSac()).get(0).getTenMauSac());
        cboHang.setSelectedItem(sanPhamNewStatic.getMaHang() + " " + hangController.timKiemHangTheoMa(sanPhamNewStatic.getMaHang()).get(0).getTenHang());
        if (sanPhamNewStatic.isTrangThai()) {
            rdoHoatDong.setSelected(true);
        } else {
            rdoKhongHoatDong.setSelected(true);
        }
        cboMaSize.setSelectedItem(sanPhamNewStatic.getMaSize() + " " + sizeController.timKiemSizeTheoMa(sanPhamNewStatic.getMaSize()).getMoTa());
        cboChatLieu.setSelectedItem(sanPhamNewStatic.getMaChatLieu() + " " + chatLieuController.timKiemChatLieuTheoMa(sanPhamNewStatic.getMaChatLieu()).getTen());
        cboNhaSanXuat.setSelectedItem(sanPhamNewStatic.getMaSanXuat() + " " + nhaSanXuatController.timKiemNSXTheoMa(sanPhamNewStatic.getMaSanXuat()).get(0).getTenNSX() + " " + nhaSanXuatController.timKiemNSXTheoMa(sanPhamNewStatic.getMaSanXuat()).get(0).getQuocGia());
        txtNgayTao.setDate(sanPhamNewStatic.getNgayTao());
        txtSoLuong.setText(String.valueOf(sanPhamNewStatic.getSoLuong()));
        txtMoTa.setText(sanPhamNewStatic.getMoTa());

        imageBytes = sanPhamNewStatic.getAnhSanPham();
        ImageIcon icon = new ImageIcon(imageBytes);
        Image scaledImage = icon.getImage().getScaledInstance(369, 470, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        txtAnh1.setIcon(icon);
    }

    private void hienThiNgaySua() {
        java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
        txtNgaySua.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboMaSize;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNhaSanXuat;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel meomeo;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhongHoatDong;
    private javax.swing.JLabel txtAnh1;
    private javax.swing.JLabel txtChatLieuKhaDung;
    private javax.swing.JLabel txtChatLieuKhongKhaDung;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JLabel txtHangKhaDung;
    private javax.swing.JLabel txtHangKhongKhaDung;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JLabel txtMauSacKhaDung;
    private javax.swing.JLabel txtMauSacKhongKhaDung;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JLabel txtNSXKhaDung;
    private javax.swing.JLabel txtNSXKhongKhaDung;
    private com.toedter.calendar.JDateChooser txtNgaySua;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
