# PBO-2 AplikasiCatatanHarian

**Nama:** Parlin

**NPM:** 2210010348

**Kelas:** 5A Reg Pagi BJB 

## Deskripsi Program:
- Aplikasi ini memungkinkan pengguna mencatat, menyimpan, mengedit, dan menghapus catatan harian.
- Catatan ditampilkan berdasarkan tanggal yang dipilih dari **CalendarPanel**.
- Tanggal dengan catatan akan di-*highlight* di kalender.

## Komponen GUI:
- JFrame  
- JPanel  
- JLabel  
- JList  
- JTextArea  
- JButton  
- CalendarPanel (LGoodDatePicker)  
- DatePicker (LGoodDatePicker)

## Logika Program:
- Data catatan disimpan dalam struktur **ArrayList** yang mencakup atribut `judul`, `isi`, dan `tanggal`.  
- Pencarian dan pengelolaan catatan dilakukan dengan memfilter berdasarkan tanggal.  
- Perhitungan tanggal menggunakan **LocalDate** dari Java Time API.  

## Events:
- **ActionListener** untuk tombol Simpan, Edit, dan Hapus.  
- **MouseListener** untuk klik pada daftar catatan.  
- **PropertyChangeListener** pada JDatePicker untuk deteksi perubahan tanggal.  

## Variasi:
- Sediakan fitur impor dan ekspor catatan menggunakan **JFileChooser**.  
- Implementasikan fitur pencarian catatan berdasarkan kata kunci.  
- Tanggal dengan catatan akan di-*highlight* di kalender.
