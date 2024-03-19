/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view_main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.TaiKhoanNhanVIenFull;
import utilities.MsgBox;
import static view_main.MenuApp.taiKhoanNhanVienControllerStatic;
import static view_main.DangNhap.Ma_NhanVienstatic;

/**
 *
 * @author Nong_Tien_Son
 */
public class ThongTinNhanVien extends javax.swing.JFrame {

    public ThongTinNhanVien() {
        initComponents();
        if (QuanLyNhanVien.tknvChiTietQL == null) {
            hienThiThongTinNhanVien(Ma_NhanVienstatic);
            rdoNhanVien.setSelected(true);
            rdoQuanLy.setEnabled(false);
            rdoNhanVien.setEnabled(false);
            rdHoatDong.setEnabled(false);
            rdKhongHoatDong.setEnabled(false);
        } else if (QuanLyNhanVien.tknvChiTietQL.getMa_NhanVien() != null) {
            if (QuanLyNhanVien.tknvChiTietQL.getMa_NhanVien().equalsIgnoreCase("NhanVienMoiNe")) {
                txtTitle.setText("THÊM NHÂN VIÊN");
                btnLeft.setText("ADD");
                setThemNhanVien();

            } else {
                hienThiThongTinNhanVien(QuanLyNhanVien.tknvChiTietQL.getMa_NhanVien());

            }

        }

    }

    private void themNhanVien() {
        if (validateTextFrom()) {
            boolean ketQua = taiKhoanNhanVienControllerStatic.themTaiKhoanNhanVien(layDuLieuTaiKhoanNhanVienMoi());

            if (ketQua) {
                MsgBox.alert(this, "Bạn đã thêm một nhân viên mới thành công !");
            } else {
                MsgBox.alert(this, "Bạn đã thêm nhân viên thất bại hãy kiểm tra lại !");
            }
        }
    }

    private TaiKhoanNhanVIenFull layDuLieuTaiKhoanNhanVienMoi() {
        TaiKhoanNhanVIenFull full = new TaiKhoanNhanVIenFull();

        full.setSoDienThoai(txtSoDienThoaiNV.getText());
        full.setMatKhau(txtMatKhauNhanVien.getText());
        full.setVaiTro(rdoQuanLy.isSelected() ? true : false);
        full.setTrangThai(rdHoatDong.isSelected() ? true : false);
        full.setHoTen(txtHoTen.getText());
        full.setGioiTinh(rdoNam.isSelected() ? true : false);
        java.util.Date utilDate = dateNgaySinh.getCalendar().getTime(); // Lấy đối tượng java.util.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Chuyển đổi sang java.sql.Date
        full.setNgaySinh(sqlDate);

        java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
        full.setNgaySua(java.sql.Date.valueOf(ngaySuaLocalDate));

        full.setDiaChi(txtDiaChi.getText());
        full.setEmail(txtEmail.getText());
        return full;
    }

    private boolean validateTextFrom() {

        if (txtSoDienThoaiNV.getText().trim().equals("")) {
            MsgBox.alert(this, "Chưa nhập số điện thoại nè bạn !");
            return false;
        }

        if (txtMatKhauNhanVien.getText().trim().equals("")) {
            MsgBox.alert(this, "Chưa nhập mật khẩu nè bạn !");
            return false;
        }

        if (rdoNhanVien.isSelected() == false) {
            if (rdoQuanLy.isSelected() == false) {
                MsgBox.alert(this, "Chưa chọn vai trò nè bạn !");
                return false;
            }
        }

        if (rdHoatDong.isSelected() == false) {
            if (rdKhongHoatDong.isSelected() == false) {
                MsgBox.alert(this, "Chưa chọn trạng thái nè bạn !");
                return false;
            }
        }

        if (txtHoTen.getText().trim().equals("")) {
            MsgBox.alert(this, "Chưa nhập họ tên nè bạn !");
            return false;
        }

        if (rdoNam.isSelected() == false) {
            if (rdNu.isSelected() == false) {
                MsgBox.alert(this, "Chưa chọn giới tính nè bạn !");
                return false;
            }
        }

        if (dateNgaySinh.getDate() == null) {
            MsgBox.alert(this, "Chưa chọn ngày sinh nè bạn !");
            return false;
        }

        if (txtDiaChi.getText().equals("")) {
            MsgBox.alert(this, "Chưa nhập địa chỉ nè bạn");
            return false;
        }

        if (txtEmail.getText().equals("")) {
            MsgBox.alert(this, "Chưa nhập email nè bạn");
            return false;
        }
        return true;
    }

    private void setThemNhanVien() {
        // Lấy thời gian hệ thống
        LocalDateTime current = LocalDateTime.now();

        // Định dạng thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatted = current.format(formatter);

        // Chuyển đổi chuỗi thành đối tượng Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = null; // Sử dụng java.util.Date
        try {
            utilDate = sdf.parse(formatted);
        } catch (ParseException ex) {
            ex.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi xảy ra trong quá trình chuyển đổi
        }

        // Chuyển đổi từ java.util.Date thành java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        // Đặt ngày cho các JDateChooser
        dateNgayTao.setDate(sqlDate);
        dateNgaySua.setDate(sqlDate);
    }

    private void hienThiThongTinNhanVien(String maNV) {
        TaiKhoanNhanVIenFull tKFull = taiKhoanNhanVienControllerStatic.selectNhanVienFull(maNV).get(0);
        txtMaNhanVien.setText(tKFull.getMa_NhanVien());
        txtSoDienThoaiNV.setText(tKFull.getSoDienThoai());
        txtMatKhauNhanVien.setText(tKFull.getMatKhau());
        if (tKFull.isVaiTro()) {
            rdoQuanLy.setSelected(true);
        } else {
            rdoNhanVien.setSelected(true);
        }
        dateNgayTao.setDate(tKFull.getNgayTao());
        dateNgaySua.setDate(tKFull.getNgaySua());
        if (tKFull.isTrangThai()) {
            rdHoatDong.setSelected(true);
        } else {
            rdKhongHoatDong.setSelected(true);
        }
        txtHoTen.setText(tKFull.getHoTen());
        if (tKFull.isGioiTinh()) {
            rdoNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        dateNgaySinh.setDate(tKFull.getNgaySinh());
        txtDiaChi.setText(tKFull.getDiaChi());
        txtEmail.setText(tKFull.getEmail());

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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMatKhauNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoDienThoaiNV = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        rdNu = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        meomeo = new javax.swing.JPanel();
        btnLeft = new javax.swing.JLabel();
        dateNgayTao = new com.toedter.calendar.JDateChooser();
        dateNgaySua = new com.toedter.calendar.JDateChooser();
        rdHoatDong = new javax.swing.JRadioButton();
        rdKhongHoatDong = new javax.swing.JRadioButton();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        txtTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtTitle.setText("   THÔNG TIN NHÂN VIÊN");
        jPanel2.add(txtTitle);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMaNhanVien.setEnabled(false);

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Số điện thoại");

        jLabel4.setText("Mật khẩu");

        jLabel5.setText("Vai Tro");

        buttonGroup2.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoQuanLy);
        rdoQuanLy.setText("Quản Lý");

        jLabel6.setText("Ngày sửa");

        jLabel7.setText("Ngày tạo");

        jLabel8.setText("Trang Thai");

        jLabel9.setText("Họ Tên");

        jLabel10.setText("Giới tính");

        jLabel11.setText("Ngày sinh");

        buttonGroup2.add(rdNu);
        rdNu.setText("Nữ");
        rdNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân Viên");
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        jLabel12.setText("Địa chỉ");

        jLabel13.setText("Email");

        meomeo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meomeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meomeoMouseClicked(evt);
            }
        });

        btnLeft.setText("EDIT");

        javax.swing.GroupLayout meomeoLayout = new javax.swing.GroupLayout(meomeo);
        meomeo.setLayout(meomeoLayout);
        meomeoLayout.setHorizontalGroup(
            meomeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meomeoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnLeft)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        meomeoLayout.setVerticalGroup(
            meomeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, meomeoLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(btnLeft)
                .addGap(21, 21, 21))
        );

        dateNgayTao.setEnabled(false);

        dateNgaySua.setEnabled(false);

        buttonGroup3.add(rdHoatDong);
        rdHoatDong.setText("Hoạt Động");
        rdHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHoatDongActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdKhongHoatDong);
        rdKhongHoatDong.setText("Không Hoạt Động");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(104, 104, 104)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoDienThoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(511, 511, 511)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(meomeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMatKhauNhanVien)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel10)
                                        .addComponent(txtDiaChi)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(dateNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rdHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdKhongHoatDong)))
                                .addGap(104, 104, 104)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateNgaySua, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoQuanLy)
                    .addComponent(rdoNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdHoatDong)
                        .addComponent(rdKhongHoatDong)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(rdNu))
                        .addGap(4, 4, 4))
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(meomeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNuActionPerformed

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNhanVienActionPerformed

    private void rdHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdHoatDongActionPerformed

    private void meomeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meomeoMouseClicked
        // TODO add your handling code here:
        if (btnLeft.getText().equals("ADD")) {
            themNhanVien();
        }
        if (btnLeft.getText().equalsIgnoreCase("EDIT")) {
            suaNhanVien();
        }
    }//GEN-LAST:event_meomeoMouseClicked
    private void suaNhanVien() {
        if (validateTextFrom()) {
            boolean ketQua = taiKhoanNhanVienControllerStatic.capNhapTaiKhoanNhanVien(layDuLieuTaiKhoanNhanVienMoi());

            if (ketQua) {
                MsgBox.alert(this, "Bạn đã sửa thành công nhân viên có số điện thoại : " + layDuLieuTaiKhoanNhanVienMoi().getSoDienThoai());
            } else {
                MsgBox.alert(this, "Bạn đã sửa thất bại nhân viên có số điện thoại : " + layDuLieuTaiKhoanNhanVienMoi().getSoDienThoai());
            }

        }
    }
    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThongTinNhanVien().setVisible(true);
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLeft;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private com.toedter.calendar.JDateChooser dateNgaySua;
    private com.toedter.calendar.JDateChooser dateNgayTao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel meomeo;
    private javax.swing.JRadioButton rdHoatDong;
    private javax.swing.JRadioButton rdKhongHoatDong;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMatKhauNhanVien;
    private javax.swing.JTextField txtSoDienThoaiNV;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables

}
