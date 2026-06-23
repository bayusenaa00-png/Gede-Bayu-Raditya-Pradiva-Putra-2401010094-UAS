/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_uas;

public class ProdukFisik extends Produk {
    private String berat;

    public ProdukFisik(int id, String nama, double harga, int stok, String berat) {
        super(id, nama, harga, stok);
        this.berat = berat;
    }

    @Override
    public String getJenis() { return "Fisik"; }

    @Override
    public String getAtributKhusus() { return this.berat; }
}