/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fuelin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author binak
 */
public class BBM extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public BBM() {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        initComponents();
        tampilTabel();

    }

    public void tampilTabel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID ");
        model.addColumn("Jenis BBM");
        model.addColumn("Total Stok");
        model.addColumn("Harga Jual");

        String sql = "SELECT * FROM bbm";

        // Eksekusi query dan tampilkan hasilnya di tabel
        try {
            Connection conn = Koneksi.konek();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idBBM = rs.getString("id_bbm");
                String nama = rs.getString("nama_bbm");
                String total = rs.getString("total_stok");
                String harga_jual = rs.getString("harga_jual");
                Object[] baris = {idBBM, nama, total+" L", harga_jual};
                model.addRow(baris);
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Memuat Data");
        }

        // Set model ke tabel
        tbBBM.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbBBM = new javax.swing.JTable();
        tfJenisBBM = new javax.swing.JTextField();
        lbJenisBBM = new javax.swing.JLabel();
        tfHargaJual = new javax.swing.JTextField();
        lbHargaJual = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tbBBM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBBM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBBMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBBM);

        tfJenisBBM.setEditable(false);
        tfJenisBBM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJenisBBMActionPerformed(evt);
            }
        });

        lbJenisBBM.setText("Jenis BBM                    :");

        tfHargaJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHargaJualActionPerformed(evt);
            }
        });

        lbHargaJual.setText("Harga Jual                   :");

        btnUbah.setBackground(new java.awt.Color(255, 165, 0));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-edit-20.png"))); // NOI18N
        btnUbah.setText("Ubah Harga Jual");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHargaJual)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbJenisBBM)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfJenisBBM, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tfHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUbah))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbJenisBBM)
                    .addComponent(tfJenisBBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHargaJual)
                    .addComponent(tfHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUbah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfJenisBBMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJenisBBMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJenisBBMActionPerformed

    private void tfHargaJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHargaJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHargaJualActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String hargaJual = tfHargaJual.getText();
        String Jenis = tfJenisBBM.getText();
        String sql = "UPDATE bbm SET harga_jual=? WHERE nama_bbm=?";
        try {
            Connection conn = Koneksi.konek();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hargaJual);
            ps.setString(2, Jenis);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
        tampilTabel();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tbBBMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBBMMouseClicked
    int barisClick = tbBBM.rowAtPoint(evt.getPoint());
        String id = tbBBM.getValueAt(barisClick, 0).toString();
        String jenis = tbBBM.getValueAt(barisClick, 1).toString();
        String totalStok = tbBBM.getValueAt(barisClick, 2).toString();
        String hargaJual = tbBBM.getValueAt(barisClick, 3).toString();
        tfJenisBBM.setText(jenis);
        tfHargaJual.setText(hargaJual);
    }//GEN-LAST:event_tbBBMMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUbah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHargaJual;
    private javax.swing.JLabel lbJenisBBM;
    private javax.swing.JTable tbBBM;
    private javax.swing.JTextField tfHargaJual;
    private javax.swing.JTextField tfJenisBBM;
    // End of variables declaration//GEN-END:variables
}
