/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaswingdev.form;

import controller.KhachHangController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.KhachHangModel;
import utilities.MsgBox;

/**
 *
 * @author Khanh
 */
public class FormKhachHang extends javax.swing.JPanel {

    KhachHangController khachHangController = new KhachHangController();
    List<KhachHangModel> danhSachkhachhang = khachHangController.timKiemTatCaKhachHang();

    /**
     * Creates new form FormKhachHang
     */
    public FormKhachHang() {
        initComponents();
        loadFormKhachHang();
    }

    private void loadFormKhachHang() {
        DefaultTableModel dtm = (DefaultTableModel) tblBangKhachHang.getModel();
        dtm.setRowCount(0);

        for (KhachHangModel khachHangModel : danhSachkhachhang) {
            dtm.addRow(new Object[]{
                khachHangModel.getMa_KhachHang(),
                khachHangModel.getTenKhachHang(),
                khachHangModel.getNgaySinh(),
                khachHangModel.isGioiTinh() ? "Nam" : "Nữ",
                khachHangModel.getSoDienThoai(),
                khachHangModel.getDiaChi(),
                
                khachHangModel.isTrangThai() ? "Hoạt động" : "Không hoạt động"
            });

        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMakhachhang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgaysinh = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtTenkhachhang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rdoHoatdong = new javax.swing.JRadioButton();
        rdoKhonghoatdong = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        txtTimkiemkhachhang = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangKhachHang = new javaswingdev.swing.table.Table();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Khách Hàng");

        jLabel8.setText("Mã khách hàng");

        jLabel3.setText("Ngày sinh");

        jLabel2.setText("Tên khách hàng");

        jLabel5.setText("Số điện thoại");

        jLabel4.setText("Giới tính");

        buttonGroup2.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup2.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel7.setText("Trạng thái");

        buttonGroup1.add(rdoHoatdong);
        rdoHoatdong.setText("Hoạt động");

        buttonGroup1.add(rdoKhonghoatdong);
        rdoKhonghoatdong.setText("Không hoạt động");

        jLabel6.setText("Địa chỉ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(71, 71, 71)
                        .addComponent(rdoNu))
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHoatdong)
                        .addGap(18, 18, 18)
                        .addComponent(rdoKhonghoatdong))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(296, 296, 296))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoHoatdong)
                        .addComponent(rdoKhonghoatdong)
                        .addComponent(rdoNu)
                        .addComponent(rdoNam))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

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

        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnTimkiem.setText("Tìm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnThem)
                .addGap(108, 108, 108)
                .addComponent(btnSua)
                .addGap(137, 137, 137)
                .addComponent(btnLammoi)
                .addGap(78, 78, 78)
                .addComponent(txtTimkiemkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnTimkiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnLammoi)
                    .addComponent(txtTimkiemkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tblBangKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Trạng thái"
            }
        ));
        tblBangKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBangKhachHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(602, 602, 602))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblBangKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangKhachHangMouseClicked
        // TODO add your handling code here:
        if (tblBangKhachHang.getSelectedRow() > -1) {
            KhachHangModel khachHangModel = khachHangController.timKiemTatCaKhachHang().get(tblBangKhachHang.getSelectedRow());
            txtTenkhachhang.setText(khachHangModel.getTenKhachHang());
            txtMakhachhang.setText(khachHangModel.getMa_KhachHang());
            txtDiachi.setText(khachHangModel.getDiaChi());
            txtSDT.setText(khachHangModel.getSoDienThoai());
            txtNgaysinh.setDate(khachHangModel.getNgaySinh());
            if (khachHangModel.isGioiTinh()) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            if (khachHangModel.isTrangThai()) {
                rdoHoatdong.setSelected(true);
            } else {
                rdoKhonghoatdong.setSelected(true);
            }
        }
    }//GEN-LAST:event_tblBangKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(checktrong()){
            boolean ketqua = khachHangController.themKhachHang(taodulieumoi());
            if(ketqua){
                MsgBox.alert(this, "Bạn đã thêm thành công");
                loadFormKhachHang();
            }else{
                MsgBox.alert(this, "Bạn đã thêm không thành công");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(tblBangKhachHang.getSelectedRow()>-1){
            boolean luachon = MsgBox.confirm(this, "Bạn có muốm sửa không?");
            if(luachon){
                boolean ketqua = khachHangController.capNhatThongTinKhachHang(taodulieumoi());
                if(ketqua){
                MsgBox.alert(this, "Bạn đã sửa thành công");
                danhSachkhachhang = khachHangController.timKiemTatCaKhachHang();
                loadFormKhachHang();
            }else{
                MsgBox.alert(this, "Bạn đã sửa không thành công");
            }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        if(txtTimkiemkhachhang.getText().trim().equals("")){
            
        }else{
            danhSachkhachhang = khachHangController.timKiemKhachHangTheoSDT(txtTimkiemkhachhang.getText());
            loadFormKhachHang();
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed
private void lammoiForm(){
    txtDiachi.setText("");
    txtMakhachhang.setText("");
    txtSDT.setText("");
    txtTenkhachhang.setText("");
    java.time.LocalDate ngaySuaLocalDate = java.time.LocalDate.now();
        txtNgaysinh.setDate(java.sql.Date.valueOf(ngaySuaLocalDate));
}
    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        lammoiForm();
    }//GEN-LAST:event_btnLammoiActionPerformed

    private KhachHangModel taodulieumoi() {
        KhachHangModel hangModel = new KhachHangModel();
        hangModel.setMa_KhachHang(txtMakhachhang.getText());
        hangModel.setTenKhachHang(txtTenkhachhang.getText());
        hangModel.setDiaChi(txtDiachi.getText());
        hangModel.setSoDienThoai(txtSDT.getText());
        hangModel.setGioiTinh(rdoNam.isSelected());
        hangModel.setTrangThai(rdoHoatdong.isSelected());
        java.util.Date utilDate = txtNgaysinh.getCalendar().getTime(); // Lấy đối tượng java.util.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Chuyển đổi sang java.sql.Date
        hangModel.setNgaySinh(sqlDate);
        
        return hangModel;
    }

    public Boolean checktrong() {
        if (txtDiachi.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập Địa chỉ");
            return false;
        }
        if (txtMakhachhang.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập Mã khách hàng");
            return false;
        }
        if (txtTenkhachhang.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập Tên khách hàng");
            return false;
        }
        if (txtSDT.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập số điện thoại");
            return false;
        }
        if(rdoHoatdong.isSelected()==false && rdoKhonghoatdong.isSelected()==false){
            MsgBox.alert(this, "Bạn cần nhập trạng thái");
            return false;
        }
        if(rdoNam.isSelected()==false && rdoNu.isSelected()==false){
            MsgBox.alert(this, "Bạn cần nhập giới tính");
            return false;
        }
        
        try {
            java.util.Date utilDate = txtNgaysinh.getCalendar().getTime(); // Lấy đối tượng java.util.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Chuyển đổi sang java.sql.Date
       
        } catch (Exception e) {
             MsgBox.alert(this, "Bạn cần nhập ngày");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoHoatdong;
    private javax.swing.JRadioButton rdoKhonghoatdong;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javaswingdev.swing.table.Table tblBangKhachHang;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtMakhachhang;
    private com.toedter.calendar.JDateChooser txtNgaysinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenkhachhang;
    private javax.swing.JTextField txtTimkiemkhachhang;
    // End of variables declaration//GEN-END:variables
}