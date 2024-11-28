/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package parlin.pkg2210010348.uts;

import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.optionalusertools.DateHighlightPolicy;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.HighlightInformation;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import parlin.pkg2210010348.uts.model.Catatan;

/**
 *
 * @author Acer
 */
public class AplikasiCatatanHarian extends javax.swing.JFrame {

    private final List<Catatan> semuaCatatan; // Menyimpan data asli

    /**
     * Creates new form AplikasiCatatanHarian
     */
    public AplikasiCatatanHarian() {
        semuaCatatan = new ArrayList<>(); // Inisialisasi daftar catatan
        initComponents();
        loadCatatanFromFile(); // Mengimpor data catatan dari file catatan.txt
        initListListener(); // Tambahkan listener untuk JList
        initCalendarListener(); // Tambahkan listener untuk Calendar
        updateListModel(semuaCatatan); // Tampilkan semua catatan di awal

        jTabbedPane2.setEnabled(false);  // Menonaktifkan semua tab

        // Mengatur locale kalender ke Bahasa Indonesia (ID)
        calendarCatatan.getSettings().setLocale(new Locale("in", "ID"));

        // Menetapkan kebijakan highlight untuk kalender
        calendarCatatan.getSettings().setHighlightPolicy(new DateHighlightPolicy() {
            @Override
            public HighlightInformation getHighlightInformationOrNull(LocalDate date) {
                // Mengecek apakah ada catatan yang tanggalnya sesuai dengan tanggal yang dipilih
                boolean hasCatatan = semuaCatatan.stream()
                        .anyMatch(catatan -> catatan.getTanggal().equals(date));

                // Jika ada catatan pada tanggal ini
                if (hasCatatan) {
                    // Mengembalikan informasi highlight dengan warna latar belakang biru dan teks putih
                    // Ini berarti tanggal ini akan disorot dengan warna biru jika ada catatan
                    return new HighlightInformation(
                            Color.BLUE, // Warna latar belakang biru
                            Color.WHITE, // Warna teks putih
                            "Ada catatan di sini!" // Tooltip yang ditampilkan saat kursor berada di tanggal tersebut
                    );
                }

                // Jika tidak ada catatan pada tanggal ini, maka tanggal ini tidak disorot
                return null;
            }
        });

    }

    private void loadCatatanFromFile() {
        // Menentukan path file catatan.txt di folder kerja saat ini
        String filePath = "catatan.txt";

        // Mencoba mengimpor catatan dari file
        try {
            List<Catatan> importedCatatan = CatatanFileHelper.importCatatanFromFile(filePath);
            semuaCatatan.addAll(importedCatatan);  // Menambahkan catatan yang diimpor ke dalam daftar
        } catch (IOException | IllegalArgumentException e) {
            // Jika ada error saat membaca file, hapus file catatan.txt
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();  // Hapus file catatan.txt jika terjadi error
            }
        }
    }

    private void initListListener() {
        listCatatan.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Pastikan hanya merespons saat pemilihan selesai
                Catatan selectedCatatan = listCatatan.getSelectedValue();
                if (selectedCatatan != null) {
                    updateLabels(selectedCatatan); // Perbarui label dengan detail catatan
                } else {
                    resetLabels(); // Reset label jika tidak ada catatan yang dipilih
                }
            }
        });
    }

    private void updateLabels(Catatan catatan) {
        lblJudulCatatan.setText(catatan.getJudul());
        lblTanggalCatatan.setText(catatan.getTanggal().toString());
        lblIsiCatatan.setText(catatan.getIsi());
    }

    private void resetLabels() {
        lblJudulCatatan.setText("Judul Catatan...");
        lblTanggalCatatan.setText("Tanggal Catatan...");
        lblIsiCatatan.setText("Isi Catatan...");
    }

    private void initCalendarListener() {
        calendarCatatan.addCalendarListener(new CalendarListener() {
            @Override
            public void selectedDateChanged(CalendarSelectionEvent cse) {
                LocalDate newDate = cse.getNewDate();
                if (newDate == null) {
                    updateListModel(semuaCatatan); // Tampilkan semua catatan
                } else {
                    filterCatatanByDate(newDate); // Tampilkan catatan berdasarkan tanggal
                }
            }

            @Override
            public void yearMonthChanged(YearMonthChangeEvent ymce) {
                // Tidak diperlukan aksi untuk perubahan bulan/tahun
            }
        });
    }

    private void filterCatatanByDate(LocalDate date) {
        List<Catatan> filteredCatatan = semuaCatatan.stream()
                .filter(catatan -> catatan.getTanggal().equals(date))
                .toList();
        updateListModel(filteredCatatan);
    }

    /**
     * Method untuk memperbarui model JList dengan daftar catatan baru
     */
    private void updateListModel(List<Catatan> daftarCatatan) {
        DefaultListModel<Catatan> model = new DefaultListModel<>();
        daftarCatatan.forEach(model::addElement); // Tambahkan semua catatan ke model
        listCatatan.setModel(model); // Set model ke JList
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
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
        btnExportCatatan = new javax.swing.JButton();
        btnImportCatatan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parlin (2210010348) Aplikasi catatan harian");

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

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

        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel4.add(btnSimpan);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel4.add(btnReset);

        btnEditCatatan.setText("Edit Catatan");
        btnEditCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCatatanActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditCatatan);

        btnHapusCatatan.setText("Hapus Catatan");
        btnHapusCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusCatatanActionPerformed(evt);
            }
        });
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
        btnCariCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariCatatanActionPerformed(evt);
            }
        });
        jPanel3.add(btnCariCatatan);

        jTabbedPane1.addTab("Cari", jPanel3);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(listCatatan);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnBuatCatatanBaru.setText("Buat Catatan Baru");
        btnBuatCatatanBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuatCatatanBaruActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(btnBuatCatatanBaru, gridBagConstraints);

        btnExportCatatan.setText("Export Catatan");
        btnExportCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCatatanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(btnExportCatatan, gridBagConstraints);

        btnImportCatatan.setText("Import Catatan");
        btnImportCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportCatatanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(btnImportCatatan, gridBagConstraints);

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // Reset filter dan tampilkan semua catatan ketika tab berubah
        updateListModel(semuaCatatan);

        // Sesuaikan ukuran tabpane berdasarkan tab yang dipilih
        switch (jTabbedPane1.getSelectedIndex()) {
            case 0:
                // Jika tab pertama (Calendar) dipilih, sesuaikan ukuran tabpane agar lebih tinggi
                jTabbedPane1.setPreferredSize(new Dimension(240, 240));
                break;
            case 1:
                // Jika tab kedua (Cari) dipilih, sesuaikan ukuran tabpane agar lebih pendek
                jTabbedPane1.setPreferredSize(new Dimension(240, 64));
                break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnCariCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariCatatanActionPerformed
        String searchText = txtCariCatatan.getText().trim().toLowerCase(); // Ambil teks pencarian dan ubah ke huruf kecil
        if (searchText.isEmpty()) {
            // Jika teks kosong, tampilkan semua catatan
            updateListModel(semuaCatatan);
        } else {
            // Filter catatan berdasarkan teks pencarian
            List<Catatan> filteredCatatan = semuaCatatan.stream()
                    .filter(catatan -> catatan.toString().toLowerCase().contains(searchText)
                    || catatan.getIsi().toLowerCase().contains(searchText))
                    .toList();
            updateListModel(filteredCatatan);
        }
    }//GEN-LAST:event_btnCariCatatanActionPerformed

    private void btnBuatCatatanBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuatCatatanBaruActionPerformed
        // Pindah ke tab "Editor" untuk membuat catatan baru
        jTabbedPane2.setSelectedIndex(1);  // 1 adalah indeks tab "Editor"

        // Aktifkan tombol simpan
        btnSimpan.setEnabled(true);

        // Nonaktifkan tombol "Buat Catatan Baru", "Edit Catatan", dan "Hapus Catatan"
        btnBuatCatatanBaru.setEnabled(false);
        btnEditCatatan.setEnabled(false);
        btnHapusCatatan.setEnabled(false);

        // Nonaktifkan JList dan tabpane kanan agar tidak bisa berinteraksi saat membuat catatan baru
        listCatatan.setEnabled(false);
        jTabbedPane2.setEnabled(false);

        // Reset fields di editor untuk memastikan form kosong
        txtJudul.setText("");
        txtIsiCatatan.setText("");
        dateTanggal.setDate(null); // Reset tanggal
    }//GEN-LAST:event_btnBuatCatatanBaruActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged

    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void btnEditCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCatatanActionPerformed
        // Pastikan ada catatan yang dipilih dari JList
        Catatan selectedCatatan = listCatatan.getSelectedValue();

        if (selectedCatatan != null) {
            // Pindah ke tab "Editor" untuk mengedit catatan yang dipilih
            jTabbedPane2.setSelectedIndex(1);  // 1 adalah indeks tab "Editor"

            // Aktifkan tombol simpan
            btnSimpan.setEnabled(true);

            // Nonaktifkan tombol "Buat Catatan Baru", "Edit Catatan", dan "Hapus Catatan"
            btnBuatCatatanBaru.setEnabled(false);
            btnEditCatatan.setEnabled(false);
            btnHapusCatatan.setEnabled(false);

            // Nonaktifkan JList dan tabpane kanan agar tidak bisa berinteraksi saat mengedit catatan
            listCatatan.setEnabled(false);
            jTabbedPane2.setEnabled(false);

            // Tampilkan detail catatan yang dipilih di editor
            txtJudul.setText(selectedCatatan.getJudul());
            txtIsiCatatan.setText(selectedCatatan.getIsi());
            dateTanggal.setDate(selectedCatatan.getTanggal());
        } else {
            // Jika tidak ada catatan yang dipilih, tampilkan pesan atau lakukan tindakan lainnya
            JOptionPane.showMessageDialog(this, "Pilih catatan yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditCatatanActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // Cek apakah ada catatan yang sedang diedit atau membuat catatan baru
        String judul = txtJudul.getText().trim();
        String isi = txtIsiCatatan.getText().trim();

        // Ambil tanggal dari JDateChooser
        LocalDate tanggal = dateTanggal.getDate();
        if (tanggal == null) {
            // Jika tanggal tidak dipilih, tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(this, "Tanggal harus dipilih!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;  // Jangan lanjutkan jika tanggal kosong
        }

        if (judul.isEmpty() || isi.isEmpty()) {
            // Jika ada field yang kosong, tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(this, "Pastikan semua kolom terisi!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;  // Jangan lanjutkan jika ada field kosong
        }

        // Jika sedang membuat catatan baru, tambahkan catatan baru ke daftar
        if (listCatatan.getSelectedValue() == null) {
            // Membuat catatan baru
            Catatan newCatatan = new Catatan(judul, tanggal, isi);
            semuaCatatan.add(newCatatan);
        } else {
            // Mengedit catatan yang dipilih
            Catatan selectedCatatan = listCatatan.getSelectedValue();
            selectedCatatan.setJudul(judul);
            selectedCatatan.setIsi(isi);
            selectedCatatan.setTanggal(tanggal);
        }

        // Update model JList dengan data terbaru
        updateListModel(semuaCatatan);

        // Reset form editor setelah simpan
        txtJudul.setText("");
        txtIsiCatatan.setText("");
        dateTanggal.setDate(null);  // Reset tanggal

        // Kembali ke tab daftar catatan setelah simpan
        jTabbedPane2.setSelectedIndex(0);  // Kembali ke tab "Daftar Catatan"

        // Aktifkan tombol "Buat Catatan Baru", "Edit Catatan", dan "Hapus Catatan"
        btnBuatCatatanBaru.setEnabled(true);
        btnEditCatatan.setEnabled(true);
        btnHapusCatatan.setEnabled(true);

        // Aktifkan JList dan tabpane kanan setelah simpan
        listCatatan.setEnabled(true);
        jTabbedPane2.setEnabled(true);

        // Nonaktifkan tombol simpan
        btnSimpan.setEnabled(false);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusCatatanActionPerformed
        // Ambil catatan yang sedang dipilih
        Catatan selectedCatatan = listCatatan.getSelectedValue();

        if (selectedCatatan != null) {
            // Konfirmasi penghapusan
            int confirmation = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin menghapus catatan ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                // Hapus catatan dari daftar
                semuaCatatan.remove(selectedCatatan);

                // Update model JList untuk menampilkan daftar catatan terbaru
                updateListModel(semuaCatatan);

                // Reset field editor setelah menghapus catatan
                txtJudul.setText("");
                txtIsiCatatan.setText("");
                dateTanggal.setDate(null);  // Reset tanggal

                // Tampilkan pesan bahwa catatan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Catatan berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Jika tidak ada catatan yang dipilih, beri peringatan
            JOptionPane.showMessageDialog(this, "Pilih catatan yang ingin dihapus terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusCatatanActionPerformed

    private void btnImportCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportCatatanActionPerformed
        // Membuat JFileChooser untuk memilih file yang akan diimpor
        JFileChooser fileChooser = new JFileChooser();

        // Set folder default ke folder kerja saat ini
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        // Set nama file default
        fileChooser.setSelectedFile(new File("catatan.txt"));

        // Set filter untuk hanya menampilkan file .txt
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));

        // Menampilkan dialog pilih file
        int result = fileChooser.showOpenDialog(this);

        // Jika user memilih tombol "Open"
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();

            try {
                // Membaca catatan dari file yang dipilih
                List<Catatan> importedCatatan = CatatanFileHelper.importCatatanFromFile(fileToOpen.getAbsolutePath());

                // Memasukkan catatan yang diimpor ke dalam list atau database aplikasi
                // Misalnya, kita menyimpan ke dalam list `semuaCatatan`
                semuaCatatan.clear(); // Jika ingin mengganti semua catatan yang ada
                semuaCatatan.addAll(importedCatatan);

                // Update model JList setelah catatan diimpor
                updateListModel(semuaCatatan);

                // Memberikan pesan keberhasilan
                JOptionPane.showMessageDialog(this, "Catatan berhasil diimpor dari " + fileToOpen.getAbsolutePath(),
                        "Impor Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengimpor catatan: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnImportCatatanActionPerformed

    private void btnExportCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCatatanActionPerformed
        // Membuat JFileChooser untuk memilih lokasi file
        JFileChooser fileChooser = new JFileChooser();

        // Set folder default ke folder kerja saat ini
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        // Set nama file default
        fileChooser.setSelectedFile(new File("catatan.txt"));

        // Set filter untuk hanya menampilkan file .txt
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));

        // Menampilkan dialog simpan file
        int result = fileChooser.showSaveDialog(this);

        // Jika user memilih tombol "Save"
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Pastikan file memiliki ekstensi .txt
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".txt")) {
                filePath += ".txt"; // Menambahkan ekstensi .txt jika belum ada
            }

            try {
                // Ambil daftar catatan
                List<Catatan> catatanList = semuaCatatan;
                // Ekspor catatan ke file yang dipilih
                CatatanFileHelper.exportCatatanToFile(catatanList, filePath);
                JOptionPane.showMessageDialog(this, "Catatan berhasil diekspor ke " + filePath,
                        "Ekspor Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengekspor catatan: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExportCatatanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Reset field teks (judul, isi catatan, dan tanggal)
        txtJudul.setText("");  // Mengosongkan JTextField untuk judul
        txtIsiCatatan.setText("");  // Mengosongkan JTextArea untuk isi catatan
        dateTanggal.setDate(null);  // Mengosongkan tanggal (null jika tidak ada tanggal yang dipilih)

        // Reset label
        resetLabels();  // Memanggil method untuk mereset label

        // Reset JList (deselect)
        listCatatan.clearSelection();  // Membatalkan pilihan pada JList

        // Aktifkan kembali kontrol yang dinonaktifkan
        btnSimpan.setEnabled(false);  // Nonaktifkan tombol simpan
        btnBuatCatatanBaru.setEnabled(true);  // Aktifkan tombol buat catatan baru
        btnEditCatatan.setEnabled(true);  // Aktifkan tombol edit catatan
        btnHapusCatatan.setEnabled(true);  // Aktifkan tombol hapus catatan

        // Aktifkan kembali JList
        listCatatan.setEnabled(true);  // Aktifkan JList

        // Pindahkan ke tab catatan 
        jTabbedPane2.setSelectedIndex(0);  // Pindah ke tab dengan index 0 (tab catatan)
    }//GEN-LAST:event_btnResetActionPerformed

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
    private javax.swing.JButton btnExportCatatan;
    private javax.swing.JButton btnHapusCatatan;
    private javax.swing.JButton btnImportCatatan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
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
    private javax.swing.JList<Catatan> listCatatan;
    private javax.swing.JTextField txtCariCatatan;
    private javax.swing.JTextArea txtIsiCatatan;
    private javax.swing.JTextField txtJudul;
    // End of variables declaration//GEN-END:variables
}
