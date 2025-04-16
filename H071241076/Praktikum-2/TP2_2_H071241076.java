class Produk {
    String id;
    String nama;
    int stok;
    int harga;

    public Produk(String id, String nama, int stok, int harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public boolean isTersedia() {
        return stok > 0;
    }

    public void cekProduk() {
        System.out.println("ID Produk   : " + id);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Stok        : " + stok);
        System.out.println("Harga       : Rp." + harga);
        System.out.println("Status      : " + (isTersedia() ? "Tersedia" : "Kosong"));
    }

}

public class Soal2 {
    public static void main(String[] args) {
        Produk produk1 = new Produk("P001", "Kopi Susu", 10, 15000);
        produk1.cekProduk();

        System.out.println();

        Produk produk2 = new Produk("P002", "Teh Manis", 0, 8000);
        produk2.cekProduk();
    }
}
