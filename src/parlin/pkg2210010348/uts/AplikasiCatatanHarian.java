/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package parlin.pkg2210010348.uts;

import java.awt.Dimension;

/**
 *
 * @author Acer
 */
public class AplikasiCatatanHarian extends javax.swing.JFrame {

    /**
     * Creates new form AplikasiCatatanHarian
     */
    public AplikasiCatatanHarian() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblJudulCatatan = new javax.swing.JLabel();
        lblTanggalCatatan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblIsiCatatan = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateTanggal = new com.github.lgooddatepicker.components.DatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIsiCatatan = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnEditCatatan = new javax.swing.JButton();
        btnHapusCatatan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        calendarCatatan = new com.github.lgooddatepicker.components.CalendarPanel();
        jPanel3 = new javax.swing.JPanel();
        txtCariCatatan = new javax.swing.JTextField();
        btnCariCatatan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCatatan = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        btnBuatCatatanBaru = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parlin (2210010348) Aplikasi catatan harian");

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 64));
        jPanel8.setLayout(new java.awt.BorderLayout());

        lblJudulCatatan.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblJudulCatatan.setText("Judul Catatan...");
        jPanel8.add(lblJudulCatatan, java.awt.BorderLayout.CENTER);

        lblTanggalCatatan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTanggalCatatan.setText("Tanggal Catatan...");
        jPanel8.add(lblTanggalCatatan, java.awt.BorderLayout.SOUTH);

        jPanel7.add(jPanel8, java.awt.BorderLayout.CENTER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diary.png"))); // NOI18N
        jLabel3.setMinimumSize(new java.awt.Dimension(64, 64));
        jLabel3.setPreferredSize(new java.awt.Dimension(64, 64));
        jPanel7.add(jLabel3, java.awt.BorderLayout.LINE_END);

        jPanel6.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel9.setLayout(new java.awt.BorderLayout());

        lblIsiCatatan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIsiCatatan.setText("Isi Catatan...");
        lblIsiCatatan.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel9.add(lblIsiCatatan, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Catatan", jPanel6);

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jPanel11.setLayout(new java.awt.GridLayout(2, 2, 4, 4));

        jLabel5.setText("Judul");
        jPanel11.add(jLabel5);
        jPanel11.add(txtJudul);

        jLabel6.setText("Tanggal");
        jPanel11.add(jLabel6);
        jPanel11.add(dateTanggal);

        jPanel10.add(jPanel11, java.awt.BorderLayout.NORTH);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Isi Catatan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        txtIsiCatatan.setColumns(20);
        txtIsiCatatan.setRows(5);
        txtIsiCatatan.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jScrollPane2.setViewportView(txtIsiCatatan);

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Editor", jPanel10);

        jPanel2.add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        btnEditCatatan.setText("Edit Catatan");
        jPanel4.add(btnEditCatatan);

        btnHapusCatatan.setText("Hapus Catatan");
        jPanel4.add(btnHapusCatatan);

        jPanel2.add(jPanel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addTab("Calendar", calendarCatatan);

        jPanel3.setPreferredSize(new java.awt.Dimension(100, 20));

        txtCariCatatan.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel3.add(txtCariCatatan);

        btnCariCatatan.setText("Cari Catatan");
        jPanel3.add(btnCariCatatan);

        jTabbedPane1.addTab("Cari", jPanel3);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(listCatatan);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnBuatCatatanBaru.setText("Buat Catatan Baru");
        jPanel5.add(btnBuatCatatanBaru);

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        switch (jTabbedPane1.getSelectedIndex()) {
            case 0: 
                jTabbedPane1.setPreferredSize(new Dimension(240, 240));
                break;
            case 1:
                jTabbedPane1.setPreferredSize(new Dimension(240, 64));
                break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikasiCatatanHarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiCatatanHarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiCatatanHarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiCatatanHarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiCatatanHarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuatCatatanBaru;
    private javax.swing.JButton btnCariCatatan;
    private javax.swing.JButton btnEditCatatan;
    private javax.swing.JButton btnHapusCatatan;
    private com.github.lgooddatepicker.components.CalendarPanel calendarCatatan;
    private com.github.lgooddatepicker.components.DatePicker dateTanggal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblIsiCatatan;
    private javax.swing.JLabel lblJudulCatatan;
    private javax.swing.JLabel lblTanggalCatatan;
    private javax.swing.JList<String> listCatatan;
    private javax.swing.JTextField txtCariCatatan;
    private javax.swing.JTextArea txtIsiCatatan;
    private javax.swing.JTextField txtJudul;
    // End of variables declaration//GEN-END:variables
}
