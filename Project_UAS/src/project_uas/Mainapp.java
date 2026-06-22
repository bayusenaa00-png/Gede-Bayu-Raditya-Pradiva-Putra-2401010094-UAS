/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

public class Mainapp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM INPUT DATA RENTAL MOBIL ===");
        
        // Interaksi menerima input dari user melalui keyboard
        System.out.print("Masukkan Merek Mobil: ");
        String merek = input.nextLine();

        System.out.print("Masukkan Model Mobil: ");
        String model = input.nextLine();

        System.out.print("Masukkan Tahun Produksi: ");
        int tahun = input.nextInt();

        System.out.print("Masukkan Harga Sewa per Hari (Rp): ");
        double harga = input.nextDouble();

        System.out.print("Masukkan Jumlah Pintu: ");
        int pintu = input.nextInt();
        input.nextLine(); // Membersihkan buffer enter setelah input angka

        System.out.print("Masukkan Jenis Bahan Bakar: ");
        String bbm = input.nextLine();

        System.out.print("Rencana durasi sewa (Hari): ");
        int durasi = input.nextInt();

        System.out.println("\n--------------------------------------");
        System.out.println("=== MEMPROSES OBJEK (OOP IN ACTION) ===");
        System.out.println("--------------------------------------");

        // Polimorfisme: Wadah bertipe induk (Project_UAS), objek bertipe anak (mobil)
        Project_UAS mobilUser = new mobil(merek, model, tahun, harga, pintu, bbm);

        // Menjalankan method-method yang ada
        mobilUser.tampilkanInfo();
        System.out.println();

        mobilUser.nyalakanMesin();
        mobilUser.servisKendaraan();

        double totalBiaya = mobilUser.hitungBiayaSewa(durasi);
        System.out.println("\nTotal Biaya Sewa untuk " + durasi + " hari: Rp" + totalBiaya);
        
        // Memanggil method overloading dengan melakukan casting ke kelas mobil
        if (mobilUser instanceof mobil) {
            double totalDenganDiskon = ((mobil) mobilUser).hitungBiayaSewa(durasi, 0.10); // Diskon 10%
            System.out.println("Promo Member (Diskon 10%): Rp" + totalDenganDiskon);
        }

        input.close();
    }
}