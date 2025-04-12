class Produk {
    private String id;
    private String nama;
    private int stok;
    private double harga;

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String namaProduk) {
        nama = namaProduk;
    }

    public void setStok(int stokProduk) {
        stok = stokProduk;
    }

    public void setHarga(double hargaProduk) {
        harga = hargaProduk;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    public boolean isAvailable() {
        return stok > 0;
    }

    public void tampilkanInfo() {
        System.out.println("ID Produk: " + id);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Status: " + (isAvailable() ? "Tersedia" : "Habis"));
    }
}

public class TP2_2_H071241064 {
    public static void main(String[] args) {
        Produk produk1 = new Produk();
        produk1.setId("P001");
        produk1.setNama("Laptop");
        produk1.setStok(10);
        produk1.setHarga(7500000);

        Produk produk2 = new Produk();
        produk2.setId("P002");
        produk2.setNama("Mouse");
        produk2.setStok(0);
        produk2.setHarga(150000);

        produk1.tampilkanInfo();
        System.out.println();
        produk2.tampilkanInfo();
    }
}