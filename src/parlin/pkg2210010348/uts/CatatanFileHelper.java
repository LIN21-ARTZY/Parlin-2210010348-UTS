/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parlin.pkg2210010348.uts;

/**
 *
 * @author Acer
 */
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import parlin.pkg2210010348.uts.model.Catatan;

public class CatatanFileHelper {

    // Fungsi untuk ekspor daftar catatan ke file teks
    public static void exportCatatanToFile(List<Catatan> catatanList, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Catatan catatan : catatanList) {
                // Tulis tanggal dan judul catatan
                writer.write(catatan.getTanggal().toString() + " :: " + catatan.getJudul());
                writer.newLine();
                
                // Tulis isi catatan
                writer.write(catatan.getIsi());
                writer.newLine();
                
                // Tambahkan pembatas antar catatan
                writer.write("---");
                writer.newLine();
            }
        }
    }

    // Fungsi untuk impor catatan dari file teks dengan validasi format, melempar exception jika format salah
    public static List<Catatan> importCatatanFromFile(String filePath) throws IOException, IllegalArgumentException {
        List<Catatan> catatanList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String tanggal = "";
            String judul = "";
            StringBuilder isi = new StringBuilder();
            boolean isValidFormat = true;
            
            while ((line = reader.readLine()) != null) {
                // Periksa apakah format file sesuai
                if (line.trim().equals("---")) {
                    // Pembatas antar catatan
                    if (!tanggal.isEmpty() && !judul.isEmpty() && isi.length() > 0) {
                        // Buat objek Catatan dan tambahkan ke list
                        Catatan catatan = new Catatan(judul, LocalDate.parse(tanggal), isi.toString());
                        catatanList.add(catatan);
                    } else {
                        // Jika pembatas ditemukan tapi data catatan tidak lengkap
                        isValidFormat = false;
                        break;
                    }
                    // Reset untuk catatan berikutnya
                    tanggal = "";
                    judul = "";
                    isi = new StringBuilder();
                } else {
                    // Proses tanggal dan judul
                    if (tanggal.isEmpty() && judul.isEmpty()) {
                        String[] parts = line.split(" :: ");
                        if (parts.length == 2) {
                            tanggal = parts[0].trim();
                            judul = parts[1].trim();
                        } else {
                            // Jika format tanggal dan judul tidak sesuai
                            isValidFormat = false;
                            break;
                        }
                    } else {
                        // Ambil isi catatan
                        isi.append(line).append("\n");
                    }
                }
            }

            // Pastikan catatan terakhir ditambahkan jika tidak ada pembatas setelahnya
            if (!tanggal.isEmpty() && !judul.isEmpty() && isi.length() > 0) {
                Catatan catatan = new Catatan(judul, LocalDate.parse(tanggal), isi.toString());
                catatanList.add(catatan);
            }

            // Jika format file tidak valid
            if (!isValidFormat) {
                throw new IllegalArgumentException("Format file catatan tidak valid. Pastikan formatnya benar.");
            }
            
        }
        return catatanList;
    }
}
