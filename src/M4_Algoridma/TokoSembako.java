package M4_Algoridma;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas ProdukSembako merepresentasikan produk sembako dengan nama, harga, dan stok.
 */
class ProdukSembako {
    private String nama;
    private int harga;
    private int stok;

    /**
     * Konstruktor untuk membuat objek ProdukSembako.
     *
     * @param nama Nama produk sembako.
     * @param harga Harga produk sembako.
     * @param stok Stok produk sembako.
     */
    public ProdukSembako(String nama, int harga, int stok) {
        this.nama  = nama;
        this.harga = harga;
        this.stok  = stok;
    }

    /**
     * Metode untuk mendapatkan nama produk.
     *
     * @return Nama produk.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Metode untuk mendapatkan harga produk.
     *
     * @return Harga produk.
     */
    public int getHarga() {
        return harga;
    }

    /**
     * Metode untuk mendapatkan stok produk.
     *
     * @return Stok produk.
     */
    public int getStok() {
        return stok;
    }

    /**
     * Metode untuk mengurangi stok produk.
     *
     * @param jumlah Jumlah produk yang dibeli.
     */
    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak cukup!");
        }
    }
}

/**
 * Kelas TokoSembako merupakan program untuk toko sembako yang mengelola daftar produk,
 * menampilkan daftar produk, dan memungkinkan pelanggan untuk melakukan pembelian.
 */
public class TokoSembako {
    private ArrayList<ProdukSembako> daftarProduk = new ArrayList<>();

    /**
     * Metode utama program yang membuat objek TokoSembako dan menginisialisasi produk sembako.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam contoh ini).
     */
    public static void main(String[] args) {
        TokoSembako toko = new TokoSembako();

        ProdukSembako produk1 = new ProdukSembako("Beras", 15000, 50);
        ProdukSembako produk2 = new ProdukSembako("Gula", 12000, 30);
        ProdukSembako produk3 = new ProdukSembako("Minyak Goreng", 20000, 40);

        toko.tambahProduk(produk1);
        toko.tambahProduk(produk2);
        toko.tambahProduk(produk3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Daftar Produk");
            System.out.println("2. Beli Produk");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                toko.tampilkanDaftarProduk();
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama produk yang ingin dibeli: ");
                String namaProduk = scanner.next();
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlahBeli = scanner.nextInt();

                for (ProdukSembako produk : toko.daftarProduk) {
                    if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                        int totalHarga = jumlahBeli * produk.getHarga();
                        if (jumlahBeli <= produk.getStok()) {
                            produk.kurangiStok(jumlahBeli);
                            System.out.println("Pembelian sukses! Total harga: " + totalHarga);
                        } else {
                            System.out.println("Stok tidak cukup!");
                        }
                    }
                }
            } else if (pilihan == 3) {
                System.out.println("Terima kasih telah berbelanja!");
                break;
            }
        }
    }

    /**
     * Metode untuk menambahkan produk ke daftar produk toko.
     *
     * @param produk ProdukSembako yang ingin ditambahkan.
     */
    public void tambahProduk(ProdukSembako produk) {
        daftarProduk.add(produk);
    }

    /**
     * Metode untuk menampilkan daftar produk toko dengan nama, harga, dan stok.
     */
    public void tampilkanDaftarProduk() {
        System.out.println("Daftar Produk Sembako:");
        for (ProdukSembako produk : daftarProduk) {
            System.out.println(produk.getNama() + " - Harga: " + produk.getHarga() + " - Stok: " + produk.getStok());
        }
    }
}