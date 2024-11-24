/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parlin.pkg2210010348.uts.model;

/**
 *
 * @author Acer
 */
import java.time.LocalDate;

public class Catatan {

    private String judul;
    private LocalDate tanggal;
    private String isi;

    // Constructor
    public Catatan(String judul, LocalDate tanggal, String isi) {
        this.judul = judul;
        this.tanggal = tanggal;
        this.isi = isi;
    }

    // Getter untuk judul
    public String getJudul() {
        return judul;
    }

    // Setter untuk judul
    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter untuk tanggal
    public LocalDate getTanggal() {
        return tanggal;
    }

    // Setter untuk tanggal
    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    // Getter untuk isi
    public String getIsi() {
        return isi;
    }

    // Setter untuk isi
    public void setIsi(String isi) {
        this.isi = isi;
    }

    // Override toString untuk tampilan di JList
    @Override
    public String toString() {
        return "[" + tanggal + "] " + judul;
    }

}
