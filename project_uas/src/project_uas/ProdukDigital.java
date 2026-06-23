/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_uas;

public class ProdukDigital extends Produk {
    private String ukuranFile;

    public ProdukDigital(int id, String nama, double harga, int stok, String ukuranFile) {
        super(id, nama, harga, stok);
        this.ukuranFile = ukuranFile;
    }

    @Override
    public String getJenis() { return "Digital"; }

    @Override
    public String getAtributKhusus() { return this.ukuranFile; }
}