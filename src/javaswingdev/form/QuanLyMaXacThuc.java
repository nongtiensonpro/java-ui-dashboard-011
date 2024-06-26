/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaswingdev.form;

import controller.QuenMatKhauController;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.MaXacNhanTaiKhoan;
import utilities.MsgBox;

/**
 *
 * @author Nong_Tien_Son
 */
public class QuanLyMaXacThuc extends javax.swing.JPanel {

    QuenMatKhauController quenMatKhauController = new QuenMatKhauController();
    List<MaXacNhanTaiKhoan> listMaXacThucTaiKhoan = quenMatKhauController.timMaXacNhan("");

    /**
     * Creates new form QuanLyMaXacThuc
     */
    public QuanLyMaXacThuc() {
        initComponents();
        hienThiLenTable();
        demMaXacThucHoatDong();
    }

    private void hienThiLenTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblXacThucTaiKhoan.getModel();
        defaultTableModel.setRowCount(0);
        for (MaXacNhanTaiKhoan maXacNhanTaiKhoan : listMaXacThucTaiKhoan) {
            defaultTableModel.addRow(new Object[]{
                maXacNhanTaiKhoan.getMaMaXacNhan(),
                maXacNhanTaiKhoan.getMaNhanVien(),
                maXacNhanTaiKhoan.getNgaySuDung(),
                maXacNhanTaiKhoan.getTrangThai() ? "Hoạt động" : "Không hoạt động"
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

        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new javaswingdev.swing.RoundPanel();
        txtSoDienThoai = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblMaHoatDong = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMaKhongHoatDong = new javax.swing.JLabel();
        roundPanel3 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXacThucTaiKhoan = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ MÃ XÁC THỰC TÀI KHOẢN");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jButton1.setText("Tìm SDT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hủy Mã");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã hoạt động");

        lblMaHoatDong.setText("0");

        jLabel4.setText("Mã không hoạt động");

        lblMaKhongHoatDong.setText("0");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaKhongHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jLabel2)
                    .addComponent(lblMaHoatDong)
                    .addComponent(jLabel4)
                    .addComponent(lblMaKhongHoatDong))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tblXacThucTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Xác Nhận", "Số Điện Thoại", "Ngày Sử Dụng", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(tblXacThucTaiKhoan);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txtSoDienThoai.getText().trim().equals("")) {
            MsgBox.alert(this, "Bạn cần nhập số điện thoại cần tìm");
            hienThiLenTable();
        } else {

            listMaXacThucTaiKhoan = quenMatKhauController.timMaXacNhan("@" + txtSoDienThoai.getText());
            hienThiLenTable();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (txtSoDienThoai.getText().trim().equals("")) {
            if (tblXacThucTaiKhoan.getSelectedRow() == -1) {
                MsgBox.alert(this, "Bạn cần nhập mã xác nhận cần hủy hoặc chọn dòng chứa mã cần hủy");
                return;
            } else {
                int dongDuocChon = tblXacThucTaiKhoan.getSelectedRow();
                String duLieuTrenCot = tblXacThucTaiKhoan.getValueAt(dongDuocChon, 0).toString();
                boolean ketQua = quenMatKhauController.voHieuHoaMaXacNhan(duLieuTrenCot);
                if (ketQua) {
                    MsgBox.alert(this, "Bạn đã hủy mã xác thực thành công !");
                    hienThiLenTable();
                } else {
                    MsgBox.alert(this, "Bạn đã hủy mã xác thực thất bại !");
                }
            }
        } else {
            boolean ketQua = quenMatKhauController.voHieuHoaMaXacNhan(txtSoDienThoai.getText());
            if (ketQua) {
                MsgBox.alert(this, "Bạn đã hủy mã xác thực thành công !");
            } else {
                MsgBox.alert(this, "Bạn đã hủy mã xác thực thất bại !");
            }
            hienThiLenTable();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listMaXacThucTaiKhoan = quenMatKhauController.timMaXacNhan("");
        hienThiLenTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        boolean luaChon = MsgBox.confirm(this, "Bạn có muốn tạo mã xác thực tài khoản mới");
        if (luaChon) {
            quenMatKhauController.themMaQuenMatKhau();
            listMaXacThucTaiKhoan = quenMatKhauController.timMaXacNhan("");
            hienThiLenTable();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lamMoiTable() {
        // TODO add your handling code here:
        txtSoDienThoai.setText("");
        listMaXacThucTaiKhoan = quenMatKhauController.timMaXacNhan("");
        hienThiLenTable();
        demMaXacThucHoatDong();
    }

    private void demMaXacThucHoatDong() {

        int maXacThucHoatDong = 0;
        int maXacThucKhongHoatDong = 0;
        for (MaXacNhanTaiKhoan maXacNhanTaiKhoan : listMaXacThucTaiKhoan) {
            if (maXacNhanTaiKhoan.getTrangThai()) {
                maXacThucHoatDong++;
            } else {
                maXacThucKhongHoatDong++;
            }
        }
        lblMaHoatDong.setText(String.valueOf(maXacThucHoatDong));
        lblMaKhongHoatDong.setText(String.valueOf(maXacThucKhongHoatDong));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaHoatDong;
    private javax.swing.JLabel lblMaKhongHoatDong;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.RoundPanel roundPanel2;
    private javaswingdev.swing.RoundPanel roundPanel3;
    private javax.swing.JTable tblXacThucTaiKhoan;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
