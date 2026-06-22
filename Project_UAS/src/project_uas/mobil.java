/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class mobil extends Project_UAS {
    // Properti tambahan spesifik mobil
    private final int jumlahPintu;
    private final String jenisBahanBakar;

    // Constructor menghubungkan data ke kelas induk (Project_UAS) menggunakan super
    public mobil(String merek, String model, int tahunProduksi, double hargaSewaPerHari, int jumlahPintu, String jenisBahanBakar) {
        super(merek, model, tahunProduksi, hargaSewaPerHari);
        this.jumlahPintu = jumlahPintu;
        this.jenisBahanBakar = jenisBahanBakar;
    }

    // Overriding Method (Polimorfisme Runtime)
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil info dari kelas induk
        System.out.println("Tipe: Mobil, Jumlah Pintu: " + jumlahPintu + ", Bahan Bakar: " + jenisBahanBakar);
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Mobil " + getMerek() + " dinyalakan dengan tombol Start/Stop Button.");
    }
    
    // Overloading Method (Polimorfisme Statis - hitung biaya sewa dengan diskon)
    public double hitungBiayaSewa(int hari, double diskon) {
        double total = super.hitungBiayaSewa(hari);
        return total - (total * diskon);
    }
}