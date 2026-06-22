            /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
public class Project_UAS {
    // 4 Properti (Attributes)
    private final String merek;
    private final String model;
    protected int tahunProduksi;
    protected double hargaSewaPerHari;

    // Constructor (Nama harus sama dengan nama kelas)
    public Project_UAS(String merek, String model, int tahunProduksi, double hargaSewaPerHari) {
        this.merek = merek;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    // Getter untuk mengambil data properti yang private
    public String getMerek() { 
        return merek; 
    }
    
    public String getModel() { 
        return model; 
    }

    // 4 Method Dasar
    public void tampilkanInfo() {
        System.out.println("Kendaraan: " + merek + " " + model + " (" + tahunProduksi + ")");
        System.out.println("Harga Sewa: Rp" + hargaSewaPerHari + "/hari");
    }

    public double hitungBiayaSewa(int hari) {
        return hargaSewaPerHari * hari;
    }

    public void servisKendaraan() {
        System.out.println("Kendaraan " + merek + " sedang dicek dan diservis rutin.");
    }

    public void nyalakanMesin() {
        System.out.println("Mesin kendaraan dinyalakan... Vroom!");
    }
}