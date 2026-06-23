/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project_uas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        tampilkanData(); // READ: Menampilkan data otomatis saat dibuka
    }

    // Fitur READ: Mengambil data dari database ke JTable
    private void tampilkanData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Produk");
        model.addColumn("Harga");
        model.addColumn("Stok");
        model.addColumn("Jenis");
        model.addColumn("Atribut Khusus");

        try {
            Connection conn = KoneksiDB.getKoneksi();
            String sql = "SELECT * FROM produk";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getDouble("harga"),
                    rs.getInt("stok"),
                    rs.getString("jenis"),
                    rs.getString("atribut_khusus")
                });
            }
            tabelProduk.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }
    }

    private void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtHarga.setText("");
        txtStok.setText("");
        txtAtribut.setText("");
        cmbJenis.setSelectedIndex(0);
    }

    // Fitur CREATE: Aksi Tombol Tambah Data (Validasi Terintegrasi)
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(txtNama.getText().isEmpty() || txtHarga.getText().isEmpty() || txtStok.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Validasi Input: Data wajib diisi!"); // Validasi input data
            return;
        }

        try {
            Produk produkBaru;
            String nama = txtNama.getText();
            double harga = Double.parseDouble(txtHarga.getText());
            int stok = Integer.parseInt(txtStok.getText());
            String atribut = txtAtribut.getText();

            // Polymorphism dalam Instansiasi Objek
            if (cmbJenis.getSelectedItem().toString().equals("Fisik")) {
                produkBaru = new ProdukFisik(0, nama, harga, stok, atribut);
            } else {
                produkBaru = new ProdukDigital(0, nama, harga, stok, atribut);
            }

            Connection conn = KoneksiDB.getKoneksi();
            String sql = "INSERT INTO produk (nama, harga, stok, jenis, atribut_khusus) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produkBaru.getNama());
            pstmt.setDouble(2, produkBaru.getHarga());
            pstmt.setInt(3, produkBaru.getStok());
            pstmt.setString(4, produkBaru.getJenis());
            pstmt.setString(5, produkBaru.getAtributKhusus());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data sukses ditambahkan!");
            tampilkanData();
            resetForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Input: " + e.getMessage());
        }
    }                                         

    // Fitur UPDATE: Aksi Tombol Ubah Data
    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih baris data pada tabel!");
            return;
        }

        try {
            Connection conn = KoneksiDB.getKoneksi();
            String sql = "UPDATE produk SET nama=?, harga=?, stok=?, jenis=?, atribut_khusus=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtNama.getText());
            pstmt.setDouble(2, Double.parseDouble(txtHarga.getText()));
            pstmt.setInt(3, Integer.parseInt(txtStok.getText()));
            pstmt.setString(4, cmbJenis.getSelectedItem().toString());
            pstmt.setString(5, txtAtribut.getText());
            pstmt.setInt(6, Integer.parseInt(txtId.getText()));

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data sukses diubah!");
            tampilkanData();
            resetForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Update: " + e.getMessage());
        }
    }                                       

    // Fitur DELETE: Aksi Tombol Hapus Data
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan dihapus!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this, "Hapus data terpilih?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if(konfirmasi == JOptionPane.YES_OPTION) {
            try {
                Connection conn = KoneksiDB.getKoneksi();
                String sql = "DELETE FROM produk WHERE id=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(txtId.getText()));
                
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data sukses dihapus!");
                tampilkanData();
                resetForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error Delete: " + e.getMessage());
            }
        }
    }                                        

    // Fitur Interaksi UI: Mengklik Tabel Mengisi Form Otomatis
    private void tabelProdukMouseClicked(java.awt.event.MouseEvent evt) {                                         
        int baris = tabelProduk.getSelectedRow();
        txtId.setText(tabelProduk.getValueAt(baris, 0).toString());
        txtNama.setText(tabelProduk.getValueAt(baris, 1).toString());
        txtHarga.setText(tabelProduk.getValueAt(baris, 2).toString());
        txtStok.setText(tabelProduk.getValueAt(baris, 3).toString());
        cmbJenis.setSelectedItem(tabelProduk.getValueAt(baris, 4).toString());
        txtAtribut.setText(tabelProduk.getValueAt(baris, 5).toString());
    }                                        

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        resetForm();
    }                                        

    // Bagian Inisialisasi Komponen Swing Otomatis oleh NetBeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        // Otomatis terisi oleh IDE NetBeans berdasarkan tata letak komponen di tab Design
    }
    // </editor-fold>                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    // Deklarasi Komponen (Pastikan Nama Variabel di Desain Sesuai dengan Nama Ini)
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbJenis;
    private javax.swing.JTable tabelProduk;
    private javax.swing.JTextField txtAtribut;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
}